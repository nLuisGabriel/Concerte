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
import {DropdownModule} from "primeng/dropdown";
import {FormsModule} from "@angular/forms";


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
    ToastModule,
    DropdownModule,
    FormsModule
  ]
})
export class CustomerModule { }
