import { Component, OnInit } from '@angular/core';
import { User } from '../models/user';
import { ServiceUsersService } from '../service-users.service'
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  user: User = new User();
  submitted = false;
 cid: any;
  

  constructor(private userService: ServiceUsersService,
    private router: Router) { }

  ngOnInit(): void {
    this.cid = sessionStorage.getItem("currentUserId");
  }

  logout() {
    sessionStorage.clear();
    // sessionStorage.("currentUserId");
    this.router.navigate(['/login'])
  }

  userSearch() {
    // this.userService.createUser(this.user)
    //   .subscribe(data => console.log(data), error => console.log(error));
    // this.user = new User();
  //  this.gotoList();
  }
  onSubmit() {
    // this.submitted = true;
    // this.save();    
  }
}
