import { Component, OnInit, NgModule } from '@angular/core';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { NgModel } from '@angular/forms';
import { PostService } from '../post.service';
import { ServiceUsersService } from '../service-users.service';
import { Post } from '../models/post';
import { User } from '../models/user';
import { Comment } from '../models/comment';
import { ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit {

  params: { followId: 1, currentUserId: 3}

  constructor(private postService: PostService, private userService: ServiceUsersService,
    private route: ActivatedRoute) { }

  user: User

  response: any;

  comment: Comment;

  post: Post;

  allPosts: Post[];

  followed: any;





  ngOnInit(): void {

    // this.postService.getAllPosts().subscribe( posts => {
    //   this.allPosts = posts;

    // })
    

  }

  follow(cid, fid) {

    this.userService.follow({"currentUserId": cid, "followId": fid})
      .subscribe(followed => {
        this.followed = followed;

      })
  }



  unfollow() {
    this.userService.unfollow(1, 3)
      .subscribe((data: Object) => this.response = {
        unfollowed: data['unfollowed']
      });

    window.alert("unfollowed");

  }

  // savePost(body: { userId: number, postId: number }): Observable<any> {
  //   return this.http.post(`${this.baseUrl}/save`, body, { responseType: 'text' });
  // }

  // unSavePost(userId: number, postId: number): Observable<any> {

  // }
}
