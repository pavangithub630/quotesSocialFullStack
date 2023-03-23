import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HomePageComponent } from '../home-page/home-page.component';


@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {

  constructor(private httpClient:HttpClient,private router:Router) { }

  email:String="";
  password:String="";

  getLoginData()  {
    let email=this.email;
    let password=this.password;
    console.log("test11111")
    let data=  this.httpClient.post("http://localhost:9111/user/user-signin", {email,password}).subscribe( resp => {console.log(resp);this.router.navigate(['/', 'home'])});
    console.log("test22222")
    console.log(data)
    return data;
  }


  ngOnInit(): void {
  }

}
