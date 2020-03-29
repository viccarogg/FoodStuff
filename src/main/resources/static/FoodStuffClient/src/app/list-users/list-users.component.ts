import { Component, OnInit } from '@angular/core';
import { User } from '../models/user';
import { ServiceUsersService } from '../service-users.service'
import { Router } from '@angular/router';
import { Observable } from "rxjs";


@Component({
  selector: 'app-list-users',
  templateUrl: './list-users.component.html',
  styleUrls: ['./list-users.component.css']
})
export class ListUsersComponent implements OnInit {
  users: Observable<User[]>;


  constructor(private userService: ServiceUsersService,private router: Router) { }

  ngOnInit(): void {
    this.reloadData();  
  }

  reloadData() {
    this.users = this.userService.getAllUsers();
  }
}
