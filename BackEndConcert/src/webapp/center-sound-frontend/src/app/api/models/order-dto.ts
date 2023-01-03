/* tslint:disable */
import { ConcertDto } from './concert-dto';
import { CustomerDto } from './customer-dto';
export interface OrderDto {
  concertDto?: ConcertDto;
  customerDto?: CustomerDto;
  id?: number;
  orderStatus?: 'ACCEPTED' | 'CANCELED';
  registeredAt?: Date;
  tickets?: number;
  total?: number;
}
