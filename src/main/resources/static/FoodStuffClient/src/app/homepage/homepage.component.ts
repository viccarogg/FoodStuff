import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';
import { ServiceUsersService } from '../service-users.service';
import { PostService } from '../post.service';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {

  username: string;
  userId: number;
  postsToDisplay: any;

  constructor(private location: Location, private userService: ServiceUsersService, private postService: PostService) { }

  ngOnInit(): void {
    if (sessionStorage.length == 0) {
      this.location.go('login')
    }
    else {
      this.username = sessionStorage.getItem("username");
      this.userId = Number(sessionStorage.getItem("currentUserId"));

      this.userService.getFollowees(this.userId).subscribe(followees => {

        if (followees.length == 0) {
          this.postService.getAllPosts().subscribe(allPosts => this.postsToDisplay = allPosts);
        }
        else {

          this.postsToDisplay = this.postService.getPostsByFollowing(followees)
          console.log(this.postsToDisplay)
        }

      });
    }
  }

  // ngDoCheck() {
  //   console.log(this.postsToDisplay);
  // }

}
