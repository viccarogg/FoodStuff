import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { NgbdModalConfig } from './create-post/create-post.component'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { CreateUserComponent } from './create-user/create-user.component';
import { ViewUserComponent } from './view-user/view-user.component';
import { LoginComponent } from './login/login.component';
import { HomepageComponent } from './homepage/homepage.component';
import { PostComponent } from './post/post.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { PostService } from './post.service';

import { NavbarComponent } from './navbar/navbar.component';
import { ListUsersComponent } from './list-users/list-users.component';







@NgModule({
  declarations: [
    AppComponent,
    CreateUserComponent,
    ViewUserComponent,
    LoginComponent,
    HomepageComponent,
    PostComponent,
    NavbarComponent,
    ListUsersComponent,
    NgbdModalConfig


  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule, 
    NgbModule

  ],
  providers: [
    PostService
  ],
  bootstrap: [AppComponent, NgbdModalConfig],
  exports: [NgbdModalConfig]
})
export class AppModule { }
