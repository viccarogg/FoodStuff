import { User } from './../models/user';
import { ServiceUsersService } from './../service-users.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;
  model = { "username": "", "password": "" };
  errorMsg;


  constructor(private serviceUsersService: ServiceUsersService, private router: Router) { }

  ngOnInit() {
  }

  login() {
    console.log(this.model.username)
    console.log(this.model.password)
    this.serviceUsersService.login(this.model)
      .subscribe(data => {
        console.log(data)
        sessionStorage.setItem("currentUserId", data.userId);
        sessionStorage.setItem("username", data.username);
        sessionStorage.setItem("email", data.email);

        this.router.navigate(['/home'])
      }, error => {
        console.log(error);
        if(!this.model.username || !this.model.password) {
          // missing at least one field
          this.errorMsg = "";
        } else {
          // both fields are there. login failed.
          this.errorMsg = "Credentials did not match any in our system."
        }

      })

  }



}
