/* tslint:disable */
import { NgModule, ModuleWithProviders } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { ApiConfiguration, ApiConfigurationInterface } from './api-configuration';

import { ArtistControllerService } from './services/artist-controller.service';
import { ConcertControllerService } from './services/concert-controller.service';
import { CustomerControllerImplService } from './services/customer-controller-impl.service';
import { MusicCategoryControllerService } from './services/music-category-controller.service';
import { OrderControllerService } from './services/order-controller.service';

/**
 * Provider for all Api services, plus ApiConfiguration
 */
@NgModule({
  imports: [
    HttpClientModule
  ],
  exports: [
    HttpClientModule
  ],
  declarations: [],
  providers: [
    ApiConfiguration,
    ArtistControllerService,
    ConcertControllerService,
    CustomerControllerImplService,
    MusicCategoryControllerService,
    OrderControllerService
  ],
})
export class ApiModule {
  static forRoot(customParams: ApiConfigurationInterface): ModuleWithProviders<ApiModule> {
    return {
      ngModule: ApiModule,
      providers: [
        {
          provide: ApiConfiguration,
          useValue: {rootUrl: customParams.rootUrl}
        }
      ]
    }
  }
}
