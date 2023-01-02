import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CustomerRoutingModule } from './customer-routing.module';
import {CustomerDetailsComponent} from "./customer-details/customer-details.component";
import {CardModule} from "primeng/card";
import {PanelModule} from "primeng/panel";
import {TableModule} from "primeng/table";
import {ButtonModule} from "primeng/button";
import {RippleModule} from "primeng/ripple";
import {InputTextModule} from "primeng/inputtext";
import {ConfirmDialogModule} from "primeng/confirmdialog";
import {ToastModule} from "primeng/toast";


@NgModule({
  declarations: [CustomerDetailsComponent],
  imports: [
    CommonModule,
    CustomerRoutingModule,
    CardModule,
    PanelModule,
    TableModule,
    ButtonModule,
    RippleModule,
    InputTextModule,
    ConfirmDialogModule,
    ToastModule
  ]
})
export class CustomerModule { }
