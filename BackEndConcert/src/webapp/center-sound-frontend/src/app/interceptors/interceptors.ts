import { HTTP_INTERCEPTORS } from "@angular/common/http";
import {RequestInterceptor} from "./RequestInterceptor";

export const interceptorProviders = [
  { provide: HTTP_INTERCEPTORS, useClass: RequestInterceptor, multi: true }
];
