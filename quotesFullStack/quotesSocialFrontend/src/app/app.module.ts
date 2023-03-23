import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { LoginPageComponent } from 'src/components/login-page/login-page.component';
import { HomePageComponent } from 'src/components/home-page/home-page.component';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import {MatCardModule} from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { SignupPageComponent } from 'src/components/signup-page/signup-page.component';
import {MatAutocompleteModule} from '@angular/material/autocomplete';
import {ReactiveFormsModule} from '@angular/forms';
import { MatIconModule } from "@angular/material/icon"; 



@NgModule({
  declarations: [
    AppComponent,
    LoginPageComponent,HomePageComponent,
    SignupPageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatCardModule,
    MatButtonModule,MatInputModule,MatFormFieldModule,FormsModule,
    HttpClientModule,
    MatAutocompleteModule,
    ReactiveFormsModule,
    MatIconModule
    
  ],
  providers: [],
  bootstrap: [AppComponent],schemas: [CUSTOM_ELEMENTS_SCHEMA],
})
export class AppModule { }
