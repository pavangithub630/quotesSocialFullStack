import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { CookieService } from 'ngx-cookie-service';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  constructor(private httpClient:HttpClient,private cookieService:CookieService) { }

  posts:any;
  
  ngOnInit():  void {
   let  userId =this.cookieService.get('userId');
    
    this.httpClient.get(`http://localhost:9111/post/getallquotes/${userId}`).subscribe((data)=>{
      
      this.posts=data;
      console.log(this.posts);
    })

    

  }

}
