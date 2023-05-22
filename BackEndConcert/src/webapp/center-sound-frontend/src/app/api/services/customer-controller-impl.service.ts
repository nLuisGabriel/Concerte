/* tslint:disable */
import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest, HttpResponse, HttpHeaders } from '@angular/common/http';
import { BaseService as __BaseService } from '../base-service';
import { ApiConfiguration as __Configuration } from '../api-configuration';
import { StrictHttpResponse as __StrictHttpResponse } from '../strict-http-response';
import { Observable as __Observable } from 'rxjs';
import { map as __map, filter as __filter } from 'rxjs/operators';

import { CustomerDto } from '../models/customer-dto';
import { Customer } from '../models/customer';

/**
 * Customer Controller Impl
 */
@Injectable({
  providedIn: 'root',
})
class CustomerControllerImplService extends __BaseService {
  static readonly getLoggedCustomerInfoUsingGETPath = '/customer/details/{email}';
  static readonly registerCustomerUsingPOSTPath = '/customer/register';

  constructor(
    config: __Configuration,
    http: HttpClient
  ) {
    super(config, http);
  }

  /**
   * getLoggedCustomerInfo
   * @param email email
   * @return OK
   */
  getLoggedCustomerInfoUsingGETResponse(email: string): __Observable<__StrictHttpResponse<CustomerDto>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;

    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/customer/details/${encodeURIComponent(String(email))}`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<CustomerDto>;
      })
    );
  }
  /**
   * getLoggedCustomerInfo
   * @param email email
   * @return OK
   */
  getLoggedCustomerInfoUsingGET(email: string): __Observable<CustomerDto> {
    return this.getLoggedCustomerInfoUsingGETResponse(email).pipe(
      __map(_r => _r.body as CustomerDto)
    );
  }

  /**
   * registerCustomer
   * @param customer customer
   * @return OK
   */
  registerCustomerUsingPOSTResponse(customer: Customer): __Observable<__StrictHttpResponse<CustomerDto>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    __body = customer;
    let req = new HttpRequest<any>(
      'POST',
      this.rootUrl + `/customer/register`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<CustomerDto>;
      })
    );
  }
  /**
   * registerCustomer
   * @param customer customer
   * @return OK
   */
  registerCustomerUsingPOST(customer: Customer): __Observable<CustomerDto> {
    return this.registerCustomerUsingPOSTResponse(customer).pipe(
      __map(_r => _r.body as CustomerDto)
    );
  }
}

module CustomerControllerImplService {
}

export { CustomerControllerImplService }
