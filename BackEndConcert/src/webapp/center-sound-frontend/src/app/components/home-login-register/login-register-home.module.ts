import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginRegisterHomeRoutingModule } from './login-register-home-routing.module';
import {HomePageComponent} from "./home-page/home-page.component";
import {ButtonModule} from "primeng/button";
import {GalleriaModule} from 'primeng/galleria';
import {PhotoService} from "../../services/photo.service";
import { RegisterPageComponent } from './register-page/register-page.component';
import { LoginPageComponent } from './login-page/login-page.component';
import {ReactiveFormsModule} from "@angular/forms";
import {CardModule} from "primeng/card";
import {ToastModule} from "primeng/toast";
import {InputTextModule} from "primeng/inputtext";
import {BrowserAnimationsModule, NoopAnimationsModule} from "@angular/platform-browser/animations";
import {PasswordModule} from "primeng/password";
import {RippleModule} from "primeng/ripple";
import {interceptorProviders} from "../../interceptors/interceptors";
import {FileUploadModule} from "primeng/fileupload";


;
@NgModule({
  declarations: [
    HomePageComponent,
    RegisterPageComponent,
    LoginPageComponent
  ],
    imports: [
        CommonModule,
        LoginRegisterHomeRoutingModule,
        ButtonModule,
        GalleriaModule,
        ReactiveFormsModule,
        CardModule,
        ToastModule,
        InputTextModule,
        PasswordModule,
        RippleModule,
        FileUploadModule,
    ],
  providers: [
    PhotoService,
    interceptorProviders
  ]
})
export class LoginRegisterHomeModule { }
