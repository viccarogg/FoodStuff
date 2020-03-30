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
import { concat } from 'rxjs';


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

  cid: any;
  username: any;

  post: Post;

  allPosts: any;
  saved: any[];
  followees: any;

  comment: any;

  postComment: any;

  
  


  ngOnInit(): void {

    this.cid = Number(sessionStorage.getItem("currentUserId"));
    this.username = sessionStorage.getItem("username");

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
      console.log(comments)
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

  // user id, postid, comment 
  createComment() {
    console.log(this.postComment)
    if (this.postComment == undefined || this.postComment == '') {
      window.alert("Please dont leave empty comments.")
    }else {
      let newComment = {"userId": {"userId": this.cid, "username": this.username},"post": {"postId": this.post.postId}, "comments": this.postComment,"flag": 0}
      console.log(newComment)
    this.commentService.createComment(newComment).subscribe(data => console.log(data));
    }
  }
  checkIfDeletable(id) {
    if(id == this.cid)
      return true;
    return false;
  }
  deleteComment(id){
    this.commentService.deleteComment(id).subscribe(data => console.log(data));
  }
}
