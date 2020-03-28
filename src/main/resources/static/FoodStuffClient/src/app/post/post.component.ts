import { Component, OnInit, NgModule } from '@angular/core';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { NgModel } from '@angular/forms';
import { PostService } from '../post.service';
import { ServiceUsersService } from '../service-users.service';
import { Post } from '../models/post';
import { User } from '../models/user';
import { Comment } from '../models/comment';


@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit {

  params: { followId: 1, currentUserId: 3}

  constructor(private postService: PostService, private userService: ServiceUsersService) { }

  user: User

  response: any;

  comment: Comment;

  post: Post;

  allPosts: Post[];

  

  ngOnInit(): void {

    

  }

  
//   getAllPosts() {
//     this.postService.getAllPosts()
//       .subscribe((data: { Post}) => this.post = {

        
//         "postId": data["postId"],
//         "title": data["title"],
//         "content": data ["content"],
//         "userId": data ["userId"],
//         "comments": [
//           "commentId",  data["commentId"],
//           "userId", data["userId"],
//           "postId", data["post"],
//           "comments", data["comments"],
//           "flag", data["flag"]
//         ]

//       });
//     window.alert(this.post);

// }

  follow() {
    this.userService.follow(this.params)
      .subscribe((data: Object) => this.response = {
        followed: data['followed']
      });

    window.alert("followed");
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
