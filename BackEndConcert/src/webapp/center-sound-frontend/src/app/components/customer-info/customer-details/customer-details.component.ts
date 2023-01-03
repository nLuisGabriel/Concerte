import {Component, OnDestroy, OnInit} from '@angular/core';
import {CustomerService} from "../../../services/customer.service";
import {CustomerControllerImplService} from "../../../api/services/customer-controller-impl.service";
import {CustomerDto} from "../../../api/models/customer-dto";
import {OrderControllerService} from "../../../api/services/order-controller.service";
import {Subscription} from "rxjs";
import {OrderDto} from "../../../api/models/order-dto";
import {ConfirmationService, MessageService, PrimeNGConfig} from "primeng/api";

@Component({
  selector: 'app-customer-details',
  templateUrl: './customer-details.component.html',
  styleUrls: ['./customer-details.component.scss'],
  providers: [ConfirmationService, MessageService]
})
export class CustomerDetailsComponent implements OnInit, OnDestroy {
  private _subscriptionList: Subscription[] = [];
  email = this._customerService.getToken()!;
  constructor(private primengConfig: PrimeNGConfig, private messageService: MessageService, private confirmationService: ConfirmationService,private orderController: OrderControllerService, private _customerController: CustomerControllerImplService, private _customerService: CustomerService) { }
  receivedCustomer: CustomerDto = { id: 1};
  orders!: OrderDto[];
  statuses = [];
  selectedOrder!: OrderDto[] | null;
  ngOnInit(): void {
    this.getUserInfo();
    this.getAllOrders();
    const x = ['CANCELED', 'ACCEPTED'];
    this.primengConfig.ripple = true;
    x.forEach((value)=>{
        // @ts-ignore
        this.statuses.push({label: value, value: value},)
      }
    )
  }

  private getUserInfo() {
    this._subscriptionList.push(this._customerController.getLoggedCustomerInfoUsingGET(this.email).subscribe((customer: CustomerDto)=>{
      console.log(customer);
      this.receivedCustomer = customer;
    }))
  }

  private getAllOrders() {
    this._subscriptionList.push(
      this.orderController.ordersByCustomerIdUsingGET(this.receivedCustomer.id!).subscribe((orders: OrderDto[])=>{
        orders.forEach(order =>{
          const [year, month, day] = order.registeredAt!.toString().split(',');
          order.registeredAt = new Date(+year, +month - 1, +day);
        })
        this.orders = orders;
      })
    )
  }


  cancelOrder(id:number) {
    console.log(this.selectedOrder)
    this.confirmationService.confirm({
      message: "Are you sure you want to cancel the selected order?",
      header: 'Confirm',
      icon: 'pi pi-exclamation-triangle',
      accept: () => {
        this._subscriptionList.push(
          this.orderController.cancelConcertTicketUsingPUT(id).subscribe({
            next:(order:OrderDto)=>{
              const [year, month, day] = order.registeredAt!.toString().split(',');
              order.registeredAt = new Date(+year, +month - 1, +day);
              this.orders[this.findIndexById(id)] = order;
              this.orders = [...this.orders];
            }
          })
        )
        this.messageService.add({
          key: 'tlr',
          severity: 'warn',
          summary: 'Warn',
          detail: 'The order has been canceled!'
        });
      }
    })
  }

  findIndexById(id: number): number {
    let index = -1;
    for (let i = 0; i < this.orders.length; i++) {
      if (this.orders[i].id === id) {
        index = i;
        break;
      }
    }

    return index;
  }
  ngOnDestroy(): void {
    this._subscriptionList.forEach((t: Subscription) => t.unsubscribe());
  }

}
