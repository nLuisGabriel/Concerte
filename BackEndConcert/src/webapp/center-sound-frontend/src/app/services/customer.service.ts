import {Injectable, OnInit} from '@angular/core';
import {BehaviorSubject, Subject, switchMap} from "rxjs";
import {Router} from "@angular/router";
import {HttpClient, HttpResponse} from "@angular/common/http";
import {CustomerControllerImplService} from "../api/services/customer-controller-impl.service";
import {CustomerDto} from "../api/models/customer-dto";

@Injectable({
  providedIn: 'root'
})
export class CustomerService implements OnInit{
  public currentUser$: BehaviorSubject<string> = new BehaviorSubject<string>("");
  public isLoggedIn$: Subject<boolean> = new Subject<boolean>();
  constructor(private _customerController: CustomerControllerImplService, private router: Router, private http: HttpClient,private customerController: CustomerControllerImplService) { }

  ngOnInit(): void {
  }
  public logout() {
    this.http.post('http://localhost:8082/logout', {withCredentials: true}).subscribe(() => {
      localStorage.removeItem('email');
      this.isLoggedIn$.next(false);
      this.router.navigate(['/account/login']).then(()=>{window.location.reload()});
    })
  }
  setToken(token: string): void{
    localStorage.setItem("email",token);
  }
  getToken(): string | null{
    return localStorage.getItem('email')
  }
  isLoggedIn(){
    return this.getToken() != null;
  }
  login(email:string, pass:string){
    let logged!: boolean;
    const formData = new FormData();
    formData.append("username",email);
    formData.append("password",pass)
    this.http.post('http://localhost:8082/login', formData, { responseType: 'text', observe: 'response', withCredentials: true })
      .subscribe({
        next:(response:HttpResponse<string>) =>{
          console.log("Login Success!");
          logged = response.ok
          this.setToken(email);
          this.currentUser$.next(email);
          this.isLoggedIn$.next(true);
          this.router.navigate(['/customer/details']).then(()=>{window.location.reload()})
        },
        error:(err: HttpResponse<string>)=>{
          logged = err.ok
          this.isLoggedIn$.next(false);
        }
      })

  }
}
