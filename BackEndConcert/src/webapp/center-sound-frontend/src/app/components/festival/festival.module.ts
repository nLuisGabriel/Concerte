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
import { ArtistsComponent } from './artists/artists.component';
import {DataViewModule} from "primeng/dataview";
import {RatingModule} from "primeng/rating";
import {TagModule} from "primeng/tag";
import {SidebarModule} from "primeng/sidebar";


@NgModule({
  declarations: [ConcertsComponent, ArtistsComponent],
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
    DropdownModule,
    DataViewModule,
    RatingModule,
    TagModule,
    SidebarModule
  ],
  providers: []
})
export class FestivalModule { }
