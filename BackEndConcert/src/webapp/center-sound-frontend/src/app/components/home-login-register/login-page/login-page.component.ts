import { Component, OnInit } from '@angular/core';
import {Subscription} from "rxjs";
import {FormBuilder, FormGroup} from "@angular/forms";
import {PrimeNGConfig} from "primeng/api";
import {CustomerService} from "../../../services/customer.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.scss']
})
export class LoginPageComponent implements OnInit {
  private _subscriptionList: Subscription[] = [];
  loginForm!: FormGroup;
  successfulLogin!: boolean;

  constructor(private _router: Router, private _formBuilder: FormBuilder, private primengConfig: PrimeNGConfig, private _customerService: CustomerService) { }

  ngOnInit(): void {
    this.checkLogin();
    this.createLoginForm();
    this.primengConfig.ripple = true;
  }

  checkLogin() {
    if (this._customerService.isLoggedIn()) {
      this._router.navigate(['customer/details']).then()
    }
  }


  Login() {
    let currentMail = this.loginForm.controls['mail'].value.toString();
    let currentPass = this.loginForm.controls['password'].value.toString();
    this._customerService.login(currentMail, currentPass);
    this._subscriptionList.push(
      this._customerService.isLoggedIn$.subscribe({
        next:(value:boolean)=>{ this.successfulLogin = value},
      })
    )
  }
  private createLoginForm() {
    this.loginForm = this._formBuilder.group({
      mail: [""],
      password: [""]
    })
  }

  goToRegisterPage() {
    this._router.navigate(['/account/register']).then();
  }

}
