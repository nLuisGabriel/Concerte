import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HeaderFooterModule} from "./components/header-footer/header-footer.module";
import {TabMenuModule} from "primeng/tabmenu";
import {FormsModule} from "@angular/forms";
import { HttpClientModule } from '@angular/common/http';
import {LoginRegisterHomeModule} from "./components/home-login-register/login-register-home.module";
import {BrowserAnimationsModule, NoopAnimationsModule} from "@angular/platform-browser/animations";
import {interceptorProviders} from "./interceptors/interceptors";



@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HeaderFooterModule,
    TabMenuModule,
    FormsModule,
    HttpClientModule,
    LoginRegisterHomeModule,
    NoopAnimationsModule,
    BrowserAnimationsModule
  ],
  providers: [interceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
