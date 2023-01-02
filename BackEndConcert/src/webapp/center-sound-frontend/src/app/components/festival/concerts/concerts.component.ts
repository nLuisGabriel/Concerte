import {Component, OnDestroy, OnInit} from '@angular/core';
import {ConcertControllerService} from "../../../api/services/concert-controller.service";
import {ConcertDto} from "../../../api/models/concert-dto";
import {Subscription} from "rxjs";
import {CustomerDto} from "../../../api/models/customer-dto";
import {CustomerControllerImplService} from "../../../api/services/customer-controller-impl.service";
import {CustomerService} from "../../../services/customer.service";
import {ConfirmationService, MessageService, PrimeNGConfig} from "primeng/api";
import { OrderControllerService} from "../../../api/services/order-controller.service";
import {OrderDto} from "../../../api/models/order-dto";
import {ArtistDto} from "../../../api/models/artist-dto";
import {ArtistControllerService} from "../../../api/services/artist-controller.service";


@Component({
  selector: 'app-concerts',
  templateUrl: './concerts.component.html',
  styleUrls: ['./concerts.component.scss'],
  providers:[ConfirmationService, MessageService]
})
export class ConcertsComponent implements OnInit, OnDestroy {
  email = this._customerService.getToken()!;
  selectedOrder: any;
  concerts!: ConcertDto[];
  private _subscriptionList: Subscription[] = [];
  private receivedCustomer!: CustomerDto;
  display!: boolean;
  ticketsNumber = 1;
  total!: number;
  selectedConcert!: ConcertDto;
  statuses = [];
  displayArtists!: boolean;
  artistsList!: ArtistDto[];

  constructor(private artistsController : ArtistControllerService, private _orderController: OrderControllerService,private primengConfig: PrimeNGConfig, private messageService: MessageService,private confirmationService: ConfirmationService,private concertController: ConcertControllerService, private _customerController: CustomerControllerImplService, private _customerService: CustomerService) { }

  ngOnInit(): void {
    this.getAllConcerts();
    this.getUserInfo();
    this.primengConfig.ripple = true;
    const x = ['DANCE', 'HIP_HOP' , 'HOUSE' , 'JAZZ' , 'POP' , 'RAP' , 'REGGAE' , 'REGGAETON' , 'ROCK']
    x.forEach((value)=>{
      // @ts-ignore
      this.statuses.push({label: value, value: value},)
      }
    )
  }
  getAllConcerts(){
    this._subscriptionList.push(
      this.concertController.findAllConcertsUsingGET().subscribe((concerts: ConcertDto[])=>{
        concerts.forEach(concert =>{
          const [year, month, day] = concert.date!.toString().split(',');
          concert.date = new Date(+year, +month - 1, +day);
        })
        this.concerts = concerts;
      })
    )
  }
  private getUserInfo() {
    this._subscriptionList.push(this._customerController.getLoggedCustomerInfoUsingGET(this.email).subscribe((customer: CustomerDto)=>{
      this.receivedCustomer = customer;
    }))
  }

  showDialog(concert: ConcertDto) {
    this.display = true;
    this.selectedConcert = concert;
    this.calculateTotal();
  }



  buyConcertTicket() {
    this.display = false;
    this.total = 0;
    const ticket :  OrderControllerService.BuyConcertTicketUsingPOSTParams ={
      quantity: this.ticketsNumber,
      customerId: this.receivedCustomer.id!,
      concertId: this.selectedConcert.id!
    }
    this._subscriptionList.push(
      this._orderController.buyConcertTicketUsingPOST(ticket).subscribe({
        next:(response: OrderDto)=>{
          this.messageService.add({
            key: 'tlr',
            severity: 'success',
            summary: 'Success',
            detail: 'The order with id '+response.id+' has been send!'
          })
        }
      })
    )
    this.ticketsNumber = 1;
  }

  cancelOperation() {
    this.display = false;
    this.total = 0;
    this.ticketsNumber = 1;
    this.messageService.add({
      key: 'tlr',
      severity: 'warn',
      summary: 'Warn',
      detail: 'The operation has been cancelled! '
    });
  }

  calculateTotal() {
    this.total = (this.selectedConcert.price! * this.ticketsNumber);
  }

  showArtists(concert: ConcertDto) {
    this.selectedConcert = concert;
    this.displayArtists = true;
    this._subscriptionList.push(
      this.artistsController.findAllArtistByConcertIdUsingGET(concert.id!).subscribe((list: ArtistDto[])=>{
        this.artistsList = list;
      })
    )
  }

  ngOnDestroy(): void {
    this._subscriptionList.forEach((x)=>x.unsubscribe());
  }

}
