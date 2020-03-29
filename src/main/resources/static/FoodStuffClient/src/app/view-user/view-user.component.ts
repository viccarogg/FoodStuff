import { Component, OnInit } from '@angular/core';
import { ServiceUsersService } from './../service-users.service';
import { PostService } from './../post.service';
import { User } from '../models/user';
import { ActivatedRoute } from '@angular/router';
import { Post } from '../models/post';

@Component({
  selector: 'app-view-user',
  templateUrl: './view-user.component.html',
  styleUrls: ['./view-user.component.css']
})
export class ViewUserComponent implements OnInit {

  user: User;
  posts: Post[];
  savedPosts: Post[];
  followers: User[];
  following: User[];
  userId: number;
  postsToDisplay: any;
  

  allPost: any;

  constructor(private userService: ServiceUsersService,
    private postService: PostService,
    private route: ActivatedRoute) { }

  ngOnInit(): void {

    this.userId = Number(sessionStorage.getItem("currentUserId"));

    this.userService.getUserById(this.route.snapshot.params.id).subscribe(u => {
      this.user = u;
    });

    this.userService.getFollowers(this.route.snapshot.params.id).subscribe(followers => {
      this.followers = followers;
    });

    this.userService.getFollowees(this.route.snapshot.params.id).subscribe(followees => {
      this.following = followees;
    });

    this.postService.getAllPosts().subscribe(data => this.allPost = data);

    this.postService.getPostsByUser(this.route.snapshot.params.id).subscribe(posts => {

      this.posts = posts;
    });


    this.postService.getSavedPostsForUser(this.route.snapshot.params.id).subscribe(savedPosts => {
      this.savedPosts = savedPosts;
    });


    this.postService.getPostsByUser(this.userId).subscribe(posts => this.postsToDisplay = posts);


  }

}
