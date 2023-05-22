import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ConcertsComponent} from "./concerts/concerts.component";
import {ArtistsComponent} from "./artists/artists.component";

const routes: Routes = [
  {path: '', redirectTo:'concerts', pathMatch:'full'},
  {path: "concerts", component: ConcertsComponent},
  {path: 'artists', component: ArtistsComponent},
  {path: '**', component:ConcertsComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class FestivalRoutingModule { }
