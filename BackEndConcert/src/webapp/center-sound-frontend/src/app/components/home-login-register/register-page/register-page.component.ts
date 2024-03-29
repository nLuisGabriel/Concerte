import {Component, OnDestroy, OnInit} from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Customer} from "../../../api/models/customer";
import {Subscription} from "rxjs";
import {CustomerControllerImplService} from "../../../api/services/customer-controller-impl.service";
import {MessageService, PrimeNGConfig} from "primeng/api";
import {Router} from "@angular/router";
import {CustomerService} from "../../../services/customer.service";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-register-page',
  templateUrl: './register-page.component.html',
  styleUrls: ['./register-page.component.scss'],
  providers:[MessageService]
})
export class RegisterPageComponent implements OnInit, OnDestroy {
  private _subscriptionList: Subscription[] = [];
  registerForm!: FormGroup;
  containSymbol = false;
  correctSize = false;
  containSmallLetter = false;
  containDigits = false;
  containCapitalLetter = false;
  picture!: any | null;

  constructor(private http: HttpClient, private customerServiceL: CustomerService, private _router: Router, private primengConfig: PrimeNGConfig, private messageService: MessageService, private _formBuilder: FormBuilder, private _customerService: CustomerControllerImplService) {
  }

  ngOnInit(): void {
    this.createRegisterForm();
    this.passwordChecker();
    this.checkLogin();
    this.primengConfig.ripple = true;
  }

  checkLogin() {
    if (this.customerServiceL.isLoggedIn()) {
      this._router.navigate(['customer/details']).then()
    }
  }

  private passwordChecker() {
    this._subscriptionList.push(
      this.registerForm.controls["password"].valueChanges.subscribe((pass: string) => {
        this.containCapitalLetter = /[A-Z]/.test(pass);
        this.containDigits = /\d/.test(pass);
        this.containSmallLetter = /[a-z]/.test(pass);
        this.correctSize = (pass.length >= 8 && pass.length <= 20);
        this.containSymbol = /[|\\/~^:,;?!&%$@*+]/.test(pass);
      })
    );
  }

  Register() {
    if(this.picture == null){
      this.defaultImage();
    }
      const registerUser: Customer = {
      age: this.registerForm.controls["age"].value,
      name: this.registerForm.controls["name"].value,
      password: this.registerForm.controls["password"].value,
      email: this.registerForm.controls["mail"].value,
      phoneNumber: this.registerForm.controls["phoneNumber"].value,
      profilePicture: this.picture
    }
    this._subscriptionList.push(
      this._customerService.registerCustomerUsingPOST(registerUser).subscribe({
        next: () => {
          this.messageService.add({
            key: "s",
            severity: 'success',
            summary: 'Success',
            detail: 'You have new account! Go to login page!'
          });
        },
        error: (error) => {
          this.messageService.add({key: "e", severity: 'error', summary: 'Error', detail: error.error});
        }
      })
    )
  }

  toLoginPage() {
    this._router.navigate(['./account/login']).then()
  }

  private createRegisterForm() {
    this.registerForm = this._formBuilder.group({
      mail: [null, [Validators.required, Validators.email]],
      password: [null, [Validators.required, Validators.pattern(/[|\\/~^:,;?!&%$@*+]/), Validators.pattern('^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$')]],
      name: [null, [Validators.required, Validators.minLength(5), Validators.maxLength(50)]],
      verifyPassword: [null, [Validators.required]],
      age: [18, [Validators.min(18), Validators.max(150), Validators.required]],
      phoneNumber: [null, [Validators.required, Validators.minLength(7), Validators.pattern('[- +()0-9]+')]]
    }, {validators: this.passMatcher})
  }

  passMatcher(c: AbstractControl): { [key: string]: boolean } | null {
    const pass = c.get('password');
    const pass2 = c.get('verifyPassword');

    if (pass!.pristine || pass2!.pristine) {
      return null;
    }

    if (pass!.value === pass2!.value) {
      return null;
    }
    return {'match': true};
  }

  myUploader($event: any) {
    let file = $event.files[0];
    this.extracted(file);

  }

  private extracted(file: Blob) {
    const reader = new FileReader();
    reader.readAsDataURL(file);
    let picture1;
    reader.onload = () => {
      picture1 = reader.result!.toString().substring(reader.result!.toString().indexOf(",") + 1);
      this.picture = picture1;
      console.log(picture1)
    };
  }

  defaultImage(){
    this.http.get('/assets/images/default.jpg', {responseType: 'blob'}).subscribe(
      (blob) => {
        let file = new File([blob], 'default.jpg');
        this.extracted(file);
      },
      (error) => {
        console.error('Error retrieving image:', error);
      }
    );
  }


  ngOnDestroy(): void {
    this._subscriptionList.forEach(t => {
      t.unsubscribe()
    });
  }

  removeImage($event: any) {
    this.defaultImage();
  }

  removeImage2($event: any) {
    this.defaultImage();
  }
}
