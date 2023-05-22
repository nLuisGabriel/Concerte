import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {RegisterPageComponent} from "./register-page/register-page.component";
import {LoginPageComponent} from "./login-page/login-page.component";

const routes: Routes = [
  {path :'', component:RegisterPageComponent},
  {path:'register', component: RegisterPageComponent},
  {path:'login', component: LoginPageComponent},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LoginRegisterHomeRoutingModule { }
