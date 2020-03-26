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
  user: User;


  constructor(private serviceUsersService: ServiceUsersService) { }

  ngOnInit() {
  }

  login(username, password) {
    this.serviceUsersService.login({username, password})
      .subscribe(data => {
        console.log(data)
        this.user = data;
      }, error => console.log(error));
  }


}
