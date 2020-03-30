import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';
import { ServiceUsersService } from '../service-users.service';
import { PostService } from '../post.service';
import { Router } from '@angular/router';



@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {

  username: string;
  userId: number;
  postsToDisplay: any;
  

  constructor(private router: Router, private userService: ServiceUsersService, private postService: PostService) { }

  ngOnInit(): void {

    

    if (sessionStorage.length == 0) {
      this.router.navigate(['/login'])
    }
    else {
      this.username = sessionStorage.getItem("username");
      this.userId = Number(sessionStorage.getItem("currentUserId"));

    

      this.userService.getFollowees(this.userId).subscribe(followees => {

        if (followees.length == 0) {
          this.postService.getAllPosts().subscribe(allPosts => this.postsToDisplay = allPosts);
          console.log("Got all the post becaus following is 0")
          console.log(this.postsToDisplay)
        }
        else {

          this.postsToDisplay = this.getPostByFollowing(followees)
          console.log("data")
          console.log(followees)

        //   this.postsToDisplay = this.postService.getPostsByFollowing(followees)
        //             console.log("got data")
        //             console.log(this.postsToDisplay)
        // }

       
          
       
        }
      });
    }
  }

  // ngDoCheck() {
  //   console.log(this.postsToDisplay);
  // }

  getPostByFollowing(followees: any) {
    for (let user of followees) {
      this.postService.getPostsByUser(user.userId)
      
      
      .subscribe(posts => {
        this.postsToDisplay = posts
      })
      console.log("other data")
      console.log(followees)
    }
  }
}
