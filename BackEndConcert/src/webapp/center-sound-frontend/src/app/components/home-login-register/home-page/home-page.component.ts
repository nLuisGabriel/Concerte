import { Component, OnInit } from '@angular/core';
import {PhotoService} from "../../../services/photo.service";
import {Router} from "@angular/router";



@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.scss']
})
export class HomePageComponent implements OnInit {
  images: any;
  responsiveOptions:any[] = [
    {
      breakpoint: '1024px',
      numVisible: 5
    },
    {
      breakpoint: '768px',
      numVisible: 3
    },
    {
      breakpoint: '560px',
      numVisible: 1
    }
  ];
  activeIndex: any;


  constructor(private photoService: PhotoService,private _router:Router ) { }



  ngOnInit(): void {
    this.photoService.getImages().then(images => this.images = images);
  }


  goToLoginPage(): void {
    this._router.navigate(['account/login']).then(window.location.reload)
  }

  goToRegisterPage(): void {
    this._router.navigate(['account/register']).then(window.location.reload)

  }
}
