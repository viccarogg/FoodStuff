import { User } from './../models/user';
import { ServiceUsersService } from './../service-users.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;
  model = {"username": "", "password":""};
  

  constructor(private serviceUsersService: ServiceUsersService) { }

  ngOnInit() {
  }

  login() {
    console.log(this.model.username)
    console.log(this.model.password)
    this.serviceUsersService.login(this.model)
      .subscribe(data => {
        sessionStorage.setItem("currentUserId", data.userId);
        sessionStorage.setItem("username", data.username);
        sessionStorage.setItem("email", data.email);
      }, error => {
        console.log(error);
      })
  }



}
