/* tslint:disable */
import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest, HttpResponse, HttpHeaders } from '@angular/common/http';
import { BaseService as __BaseService } from '../base-service';
import { ApiConfiguration as __Configuration } from '../api-configuration';
import { StrictHttpResponse as __StrictHttpResponse } from '../strict-http-response';
import { Observable as __Observable } from 'rxjs';
import { map as __map, filter as __filter } from 'rxjs/operators';

import { OrderDto } from '../models/order-dto';

/**
 * Order Controller
 */
@Injectable({
  providedIn: 'root',
})
class OrderControllerService extends __BaseService {
  static readonly buyConcertTicketUsingPOSTPath = '/orders/buy/{customerId}/{concertId}/{quantity}';
  static readonly cancelConcertTicketUsingPUTPath = '/orders/cancelOrder/{orderID}';
  static readonly ordersByCustomerIdUsingGETPath = '/orders/getAll/{customerId}';

  constructor(
    config: __Configuration,
    http: HttpClient
  ) {
    super(config, http);
  }

  /**
   * buyConcertTicket
   * @param params The `OrderControllerService.BuyConcertTicketUsingPOSTParams` containing the following parameters:
   *
   * - `quantity`: quantity
   *
   * - `customerId`: customerId
   *
   * - `concertId`: concertId
   *
   * @return OK
   */
  buyConcertTicketUsingPOSTResponse(params: OrderControllerService.BuyConcertTicketUsingPOSTParams): __Observable<__StrictHttpResponse<OrderDto>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;



    let req = new HttpRequest<any>(
      'POST',
      this.rootUrl + `/orders/buy/${encodeURIComponent(String(params.customerId))}/${encodeURIComponent(String(params.concertId))}/${encodeURIComponent(String(params.quantity))}`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<OrderDto>;
      })
    );
  }
  /**
   * buyConcertTicket
   * @param params The `OrderControllerService.BuyConcertTicketUsingPOSTParams` containing the following parameters:
   *
   * - `quantity`: quantity
   *
   * - `customerId`: customerId
   *
   * - `concertId`: concertId
   *
   * @return OK
   */
  buyConcertTicketUsingPOST(params: OrderControllerService.BuyConcertTicketUsingPOSTParams): __Observable<OrderDto> {
    return this.buyConcertTicketUsingPOSTResponse(params).pipe(
      __map(_r => _r.body as OrderDto)
    );
  }

  /**
   * cancelConcertTicket
   * @param orderID orderID
   * @return OK
   */
  cancelConcertTicketUsingPUTResponse(orderID: number): __Observable<__StrictHttpResponse<OrderDto>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;

    let req = new HttpRequest<any>(
      'PUT',
      this.rootUrl + `/orders/cancelOrder/${encodeURIComponent(String(orderID))}`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<OrderDto>;
      })
    );
  }
  /**
   * cancelConcertTicket
   * @param orderID orderID
   * @return OK
   */
  cancelConcertTicketUsingPUT(orderID: number): __Observable<OrderDto> {
    return this.cancelConcertTicketUsingPUTResponse(orderID).pipe(
      __map(_r => _r.body as OrderDto)
    );
  }

  /**
   * ordersByCustomerId
   * @param customerId customerId
   * @return OK
   */
  ordersByCustomerIdUsingGETResponse(customerId: number): __Observable<__StrictHttpResponse<Array<OrderDto>>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;

    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/orders/getAll/${encodeURIComponent(String(customerId))}`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<Array<OrderDto>>;
      })
    );
  }
  /**
   * ordersByCustomerId
   * @param customerId customerId
   * @return OK
   */
  ordersByCustomerIdUsingGET(customerId: number): __Observable<Array<OrderDto>> {
    return this.ordersByCustomerIdUsingGETResponse(customerId).pipe(
      __map(_r => _r.body as Array<OrderDto>)
    );
  }
}

module OrderControllerService {

  /**
   * Parameters for buyConcertTicketUsingPOST
   */
  export interface BuyConcertTicketUsingPOSTParams {

    /**
     * quantity
     */
    quantity: number;

    /**
     * customerId
     */
    customerId: number;

    /**
     * concertId
     */
    concertId: number;
  }
}

export { OrderControllerService }
