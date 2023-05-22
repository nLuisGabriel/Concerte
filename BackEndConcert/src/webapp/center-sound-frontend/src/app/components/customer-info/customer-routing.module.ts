import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {CustomerDetailsComponent} from "./customer-details/customer-details.component";

const routes: Routes = [
  {path: '', redirectTo: 'details', pathMatch: 'full'},
  {path: 'details', component: CustomerDetailsComponent},
  {path: '**', component: CustomerDetailsComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CustomerRoutingModule { }
