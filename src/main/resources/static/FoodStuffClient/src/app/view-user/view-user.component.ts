import { Component, OnInit, OnDestroy } from '@angular/core';
import { ServiceUsersService } from './../service-users.service';
import { PostService } from './../post.service';
import { User } from '../models/user';
import { ActivatedRoute, Router, RouterEvent, NavigationEnd } from '@angular/router';
import { Post } from '../models/post';
import { Subject } from 'rxjs';
import{ takeUntil, filter }from'rxjs/operators';

@Component({
  selector: 'app-view-user',
  templateUrl: './view-user.component.html',
  styleUrls: ['./view-user.component.css']
})
export class ViewUserComponent implements OnInit, OnDestroy {

  user: User;
  posts: Post[];
  savedPosts: Post[];
  followers: User[];
  following: User[];
  userId: number;
  postsToDisplay: any;
  seeFollowers: any;
  seeFollowing: any;

  public destroyed = new Subject<any>();

  allPost: any;

  constructor(private userService: ServiceUsersService,
    private postService: PostService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.fetchData();
    this.router.events.pipe(
      filter((event: RouterEvent) => event instanceof NavigationEnd),
      takeUntil(this.destroyed)
    ).subscribe(() => {
      this.fetchData();
    });
  }

  ngOnDestroy(): void {
    this.destroyed.next();
    this.destroyed.complete();
  }


  fetchData() {
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

     this.userService.getFollowers(this.userId).subscribe(users => this.seeFollowers = users)

     this.userService.getFollowees(this.userId).subscribe(user => this.seeFollowing = user)

  }

  reload() {
    window.location.reload();
  }

}
