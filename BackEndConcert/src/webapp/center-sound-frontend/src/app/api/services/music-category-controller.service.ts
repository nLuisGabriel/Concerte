/* tslint:disable */
import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest, HttpResponse, HttpHeaders } from '@angular/common/http';
import { BaseService as __BaseService } from '../base-service';
import { ApiConfiguration as __Configuration } from '../api-configuration';
import { StrictHttpResponse as __StrictHttpResponse } from '../strict-http-response';
import { Observable as __Observable } from 'rxjs';
import { map as __map, filter as __filter } from 'rxjs/operators';

import { MusicalCategory } from '../models/musical-category';

/**
 * Music Category Controller
 */
@Injectable({
  providedIn: 'root',
})
class MusicCategoryControllerService extends __BaseService {
  static readonly findAllMusicalCategoryUsingGETPath = '/musicCategory/getAll';

  constructor(
    config: __Configuration,
    http: HttpClient
  ) {
    super(config, http);
  }

  /**
   * findAllMusicalCategory
   * @return OK
   */
  findAllMusicalCategoryUsingGETResponse(): __Observable<__StrictHttpResponse<Array<MusicalCategory>>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/musicCategory/getAll`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<Array<MusicalCategory>>;
      })
    );
  }
  /**
   * findAllMusicalCategory
   * @return OK
   */
  findAllMusicalCategoryUsingGET(): __Observable<Array<MusicalCategory>> {
    return this.findAllMusicalCategoryUsingGETResponse().pipe(
      __map(_r => _r.body as Array<MusicalCategory>)
    );
  }
}

module MusicCategoryControllerService {
}

export { MusicCategoryControllerService }
