import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';
import { HomePageComponent } from '../home-page/home-page.component';


@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {

  constructor(private httpClient:HttpClient,private router:Router
    ,private cookieService:CookieService) { }

  email:String="";
  password:String="";
  user:any;

  getLoginData()  {
    let email=this.email;
    let password=this.password;
    this.httpClient.post("http://localhost:9111/user/user-signin", {email,password}).subscribe( resp =>
     {console.log(resp);
      this.user=resp;
      this.cookieService.set( 'userId', this.user.userId );
      console.log(this.cookieService.get('userId'))
      this.router.navigate(['/', 'home'])});
    return null;
  }


  ngOnInit(): void {
  }

}
