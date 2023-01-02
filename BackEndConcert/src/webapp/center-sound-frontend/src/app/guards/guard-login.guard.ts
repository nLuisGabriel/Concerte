import { Injectable } from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree} from '@angular/router';
import { Observable } from 'rxjs';
import {CustomerService} from "../services/customer.service";

@Injectable({
  providedIn: 'root'
})
export class GuardLoginGuard implements CanActivate {
  constructor(private _auth: CustomerService, private _router: Router) {

  }

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot):  boolean {
    if(!this._auth.isLoggedIn()){
      this._router.navigate(['account/login']).then()
      return false;
    }
    return this._auth.isLoggedIn();
  }

}
