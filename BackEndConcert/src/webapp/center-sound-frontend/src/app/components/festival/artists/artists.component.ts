import {Component, OnDestroy, OnInit} from '@angular/core';
import {Subscription} from "rxjs";
import {ArtistControllerService} from "../../../api/services/artist-controller.service";
import {ArtistDto} from "../../../api/models/artist-dto";
import {ConcertControllerService} from "../../../api/services/concert-controller.service";
import {ConcertDto} from "../../../api/models/concert-dto";
import {Router} from "@angular/router";

@Component({
  selector: 'app-artists',
  templateUrl: './artists.component.html',
  styleUrls: ['./artists.component.scss']
})
export class ArtistsComponent implements OnInit, OnDestroy {

  concertsByArtists: ConcertDto[] = [];
  private subs: Subscription[] = [];
  rating: number = 5;
  artists: ArtistDto[] = [];
  sidebarVisible: boolean = false;
  constructor(private _artistController: ArtistControllerService, private _concertController: ConcertControllerService, private _router: Router) {

  }

  ngOnInit(): void {
    this.loadArtists();
  }

  private loadArtists() {
    this.subs.push(
      this._artistController.findAllArtistsUsingGET().subscribe({
        next: (value: ArtistDto[]) => {
          this.artists = value;
        }
      })
    )
  }

  ngOnDestroy(): void {
    this.subs.forEach(value => {value.unsubscribe()});
  }

  searchConcertsByArtist(id: number) {
    this.subs.push(
      this._concertController.findAllConcertsByArtistIdUsingGET(id).subscribe({
        next: (value: ConcertDto[]) => {
          value.forEach(concert => {
            const [year, month, day] = concert.date!.toString().split(',');
            concert.date = new Date(+year, +month - 1, +day);
          })
          this.concertsByArtists = value;
          this.sidebarVisible = true
        }
      })
    )
  }

  goToConcert(concert: ConcertDto) {
    this._router.navigate(['festivals/concerts'], {queryParams: {'concertID':concert!.id!}})
  }
}
