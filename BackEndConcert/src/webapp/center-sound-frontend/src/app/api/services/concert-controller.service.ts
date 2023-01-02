/* tslint:disable */
import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest, HttpResponse, HttpHeaders } from '@angular/common/http';
import { BaseService as __BaseService } from '../base-service';
import { ApiConfiguration as __Configuration } from '../api-configuration';
import { StrictHttpResponse as __StrictHttpResponse } from '../strict-http-response';
import { Observable as __Observable } from 'rxjs';
import { map as __map, filter as __filter } from 'rxjs/operators';

import { ConcertDto } from '../models/concert-dto';

/**
 * Concert Controller
 */
@Injectable({
  providedIn: 'root',
})
class ConcertControllerService extends __BaseService {
  static readonly findAllConcertsUsingGETPath = '/concerts/getAll';
  static readonly findAllConcertsByArtistIdUsingGETPath = '/concerts/getAllByArtistId/{artistId}';

  constructor(
    config: __Configuration,
    http: HttpClient
  ) {
    super(config, http);
  }

  /**
   * findAllConcerts
   * @return OK
   */
  findAllConcertsUsingGETResponse(): __Observable<__StrictHttpResponse<Array<ConcertDto>>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/concerts/getAll`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<Array<ConcertDto>>;
      })
    );
  }
  /**
   * findAllConcerts
   * @return OK
   */
  findAllConcertsUsingGET(): __Observable<Array<ConcertDto>> {
    return this.findAllConcertsUsingGETResponse().pipe(
      __map(_r => _r.body as Array<ConcertDto>)
    );
  }

  /**
   * findAllConcertsByArtistId
   * @param artistId artistId
   * @return OK
   */
  findAllConcertsByArtistIdUsingGETResponse(artistId: number): __Observable<__StrictHttpResponse<Array<ConcertDto>>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;

    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/concerts/getAllByArtistId/${encodeURIComponent(String(artistId))}`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<Array<ConcertDto>>;
      })
    );
  }
  /**
   * findAllConcertsByArtistId
   * @param artistId artistId
   * @return OK
   */
  findAllConcertsByArtistIdUsingGET(artistId: number): __Observable<Array<ConcertDto>> {
    return this.findAllConcertsByArtistIdUsingGETResponse(artistId).pipe(
      __map(_r => _r.body as Array<ConcertDto>)
    );
  }
}

module ConcertControllerService {
}

export { ConcertControllerService }
