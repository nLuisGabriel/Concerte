/* tslint:disable */
import { LocationDto } from './location-dto';
import { MusicalCategoryDto } from './musical-category-dto';
export interface ConcertDto {
  date?: Date;
  id?: number;
  locationDto?: LocationDto;
  musicalCategoryDto?: MusicalCategoryDto;
  name?: string;
  price?: number;
}
