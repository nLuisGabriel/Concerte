import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FestivalRoutingModule } from './festival-routing.module';
import {ConcertsComponent} from "./concerts/concerts.component";
import {PanelModule} from "primeng/panel";
import {TableModule} from "primeng/table";
import {InputTextModule} from "primeng/inputtext";
import {ButtonModule} from "primeng/button";
import {RippleModule} from "primeng/ripple";
import {DialogModule} from 'primeng/dialog';
import {InputNumberModule} from "primeng/inputnumber";
import {FormsModule} from "@angular/forms";
import {ToastModule} from "primeng/toast";
import {DropdownModule} from "primeng/dropdown";


@NgModule({
  declarations: [ConcertsComponent],
  imports: [
    CommonModule,
    FestivalRoutingModule,
    PanelModule,
    TableModule,
    InputTextModule,
    ButtonModule,
    RippleModule,
    DialogModule,
    InputNumberModule,
    FormsModule,
    ToastModule,
    DropdownModule
  ]
})
export class FestivalModule { }
