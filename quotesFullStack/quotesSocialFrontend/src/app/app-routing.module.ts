import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddFriendsComponent } from 'src/components/add-friends/add-friends.component';
import { HomePageComponent } from 'src/components/home-page/home-page.component';
import { LoginPageComponent } from 'src/components/login-page/login-page.component';
import { SideNavComponent } from 'src/components/side-nav/side-nav.component';
import { SignupPageComponent } from 'src/components/signup-page/signup-page.component';
import { AppComponent } from './app.component';

const routes: Routes = [{path:"",component:LoginPageComponent},
{path:"home",component:HomePageComponent},
{path:"signup",component:SignupPageComponent},
{path:"nav",component:SideNavComponent},
{path:"find-friends",component:AddFriendsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
