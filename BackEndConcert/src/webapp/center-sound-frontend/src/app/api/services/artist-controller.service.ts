/* tslint:disable */
import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest, HttpResponse, HttpHeaders } from '@angular/common/http';
import { BaseService as __BaseService } from '../base-service';
import { ApiConfiguration as __Configuration } from '../api-configuration';
import { StrictHttpResponse as __StrictHttpResponse } from '../strict-http-response';
import { Observable as __Observable } from 'rxjs';
import { map as __map, filter as __filter } from 'rxjs/operators';

import { ArtistDto } from '../models/artist-dto';

/**
 * Artist Controller
 */
@Injectable({
  providedIn: 'root',
})
class ArtistControllerService extends __BaseService {
  static readonly findAllArtistsUsingGETPath = '/artists/getAll';
  static readonly findAllArtistByConcertIdUsingGETPath = '/artists/getAllByConcertId/{concertId}';

  constructor(
    config: __Configuration,
    http: HttpClient
  ) {
    super(config, http);
  }

  /**
   * findAllArtists
   * @return OK
   */
  findAllArtistsUsingGETResponse(): __Observable<__StrictHttpResponse<Array<ArtistDto>>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/artists/getAll`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<Array<ArtistDto>>;
      })
    );
  }
  /**
   * findAllArtists
   * @return OK
   */
  findAllArtistsUsingGET(): __Observable<Array<ArtistDto>> {
    return this.findAllArtistsUsingGETResponse().pipe(
      __map(_r => _r.body as Array<ArtistDto>)
    );
  }

  /**
   * findAllArtistByConcertId
   * @param concertId concertId
   * @return OK
   */
  findAllArtistByConcertIdUsingGETResponse(concertId: number): __Observable<__StrictHttpResponse<Array<ArtistDto>>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;

    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/artists/getAllByConcertId/${encodeURIComponent(String(concertId))}`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<Array<ArtistDto>>;
      })
    );
  }
  /**
   * findAllArtistByConcertId
   * @param concertId concertId
   * @return OK
   */
  findAllArtistByConcertIdUsingGET(concertId: number): __Observable<Array<ArtistDto>> {
    return this.findAllArtistByConcertIdUsingGETResponse(concertId).pipe(
      __map(_r => _r.body as Array<ArtistDto>)
    );
  }
}

module ArtistControllerService {
}

export { ArtistControllerService }
