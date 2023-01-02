import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ConcertsComponent} from "./concerts/concerts.component";

const routes: Routes = [
  {path: '', redirectTo:'concerts', pathMatch:'full'},
  {path: "concerts", component: ConcertsComponent},
  {path: '**', component:ConcertsComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class FestivalRoutingModule { }
