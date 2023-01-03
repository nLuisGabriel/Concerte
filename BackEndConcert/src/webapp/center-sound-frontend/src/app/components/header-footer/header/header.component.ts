import { Component, OnInit } from '@angular/core';
import {MenuItem, PrimeIcons} from 'primeng/api';
import {Router} from "@angular/router";
import {CustomerService} from "../../../services/customer.service";


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
  items!: MenuItem[];
  activeItem: any;

  constructor(private _customerService: CustomerService, private router: Router) { }

  ngOnInit(): void {
    this.navigationBarConfiguration();
  }

  private navigationBarConfiguration() {
    this._customerService.isLoggedIn()? this.loggedHeader() : this.defaultHeader();
  }

  private loggedHeader() {
    this.items = [
      {
        label: "Festivals", icon: PrimeIcons.TICKET, command: () => {
          this.router.navigate(['festivals/concerts']).then()
        }
      },
      {
        label: "Account Details", icon: PrimeIcons.USERS, command: () => {
          this.router.navigate(['customer/details']).then()
        }
      },
      {
        label: "Logout", icon: PrimeIcons.SIGN_OUT,
        command: () => {
          if (this._customerService.isLoggedIn()) {
            this.logout()
          }
        }
      }
    ]
  }

  private defaultHeader() {
    this.items = [
      {label: "Home Page", icon: PrimeIcons.HOME, routerLink: "home"},
      {label: "Login Page", icon: PrimeIcons.SIGN_IN,routerLink: "account/login"},
      {label: "Register page", icon: PrimeIcons.USER, routerLink: "account/register"},
    ]
  }
  private logout() {
    this._customerService.logout();
  }

  goTo() {
    if(this._customerService.isLoggedIn()){
      this.router.navigate(['customer/details']).then()
    }
    else{
      this.router.navigate(['home']).then()
    }
  }
}
