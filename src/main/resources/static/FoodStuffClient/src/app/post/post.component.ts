import { Component, OnInit, NgModule } from '@angular/core';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { NgModel } from '@angular/forms';
import { PostService } from '../post.service';
import { ServiceUsersService } from '../service-users.service';
import { Post } from '../models/post';
import { User } from '../models/user';
import { Comment } from '../models/comment';
import { ActivatedRoute } from '@angular/router';
import { Title } from '@angular/platform-browser';
import { CommentService } from '../comment.service';


@Component({
  selector: 'app-post',
  inputs: ['postId'],
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit {
  postId: number;


  params: { followId: 1, currentUserId: 3 }

  constructor(private postService: PostService, private userService: ServiceUsersService, private commentService: CommentService,
    private route: ActivatedRoute) { }

  user: User

  response: any;

  comment: any;

  post: Post;

  allPosts: any;
  saved: any[];
  followees: any;

  cid = Number(sessionStorage.getItem("currentUserId"));


  ngOnInit(): void {

    this.postService.getPost(this.postId).subscribe(post => {
      this.post = post;
    })

    this.userService.getFollowees(this.cid).subscribe(followees => {
      this.followees = followees;
    })

    this.postService.getSavedPostsForUser(this.cid).subscribe(savedPosts => {
      this.saved = savedPosts;
    })

    this.commentService.getCommentsByPostId(this.postId).subscribe(comments => {
      this.comment = comments;
    })

  }

  follow(fid) {
    console.log(fid);
    this.userService.follow({ "currentUserId": this.cid, "followId": fid })
      .subscribe(followed => {
        console.log("succeess/fail msg")

      })
  }



  unfollow(fid) {
    this.userService.unfollow(fid, this.cid)
      .subscribe((data: Object) => this.response = {
        unfollowed: data['unfollowed']
      });

    window.alert("unfollowed");

  }

  savePost(pid) {
    console.log(pid);
    this.userService.savePost({ "userId": this.cid, "postId": pid })
      .subscribe(saved => {
        console.log("success!")
      })
  }

  unsavePost(pid: number) {
    this.userService.unSavePost(this.cid, pid).subscribe(unsave => {
      console.log("post unsaved :(")
    })
  }

  checkIfFollowing(id) {
      for (let u of this.followees)
        if (u.userId == id)
          return true;
    return false;
  }
  checkIfSaved(id) {
    console.log(this.saved);
    for (let p of this.saved)
        if (p.postId == id)
          return true;
    return false;
  }
}
