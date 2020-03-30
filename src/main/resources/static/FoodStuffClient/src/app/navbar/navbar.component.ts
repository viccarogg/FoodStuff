import { Component, OnInit } from '@angular/core';
import { User } from '../models/user';
import { ServiceUsersService } from '../service-users.service'
import { Router } from '@angular/router';
import {PostService} from '../post.service';
import { Post } from '../models/post';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  user: User = new User();
  submitted = false;

  searchParam:string;

  // cid = Number(sessionStorage.getItem("currentUserId"));

   cid: any;


   constructor(private userService: ServiceUsersService,private postService: PostService,private router: Router) { }

  ngOnInit(): void {
    this.cid = parseInt(sessionStorage.getItem("currentUserId"));
  }

  logout() {
    sessionStorage.clear();
    this.router.navigate(['/login'])
  }

  Search() {
  if (this.searchParam != undefined)
  {  
   // search recipe titles
    this.router.navigate(['/search/'+ this.searchParam]);
  }
  else
  {  
    this.router.navigate(['/allusers']);}
  }


  onSubmit() {
    this.Search();  
  }


}
