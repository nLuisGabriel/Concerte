import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomePageComponent} from "./components/home-login-register/home-page/home-page.component";
import {GuardLoginGuard} from "./guards/guard-login.guard";

const routes: Routes = [
  {path: '',redirectTo:'/account/login', pathMatch: 'full'},
  {path: 'home', component: HomePageComponent},
  {path: 'account',loadChildren: () => import('./components/home-login-register/login-register-home.module').then((m)=>m.LoginRegisterHomeModule)},
  {path: 'customer', canActivate:[GuardLoginGuard], loadChildren:()=>import('./components/customer-info/customer.module').then((m)=>m.CustomerModule)},
  {path: 'festivals', canActivate:[GuardLoginGuard], loadChildren:()=>import('./components/festival/festival.module').then((m)=>m.FestivalModule)}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
