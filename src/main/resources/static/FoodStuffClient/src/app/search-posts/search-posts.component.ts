import { Component, OnInit, OnDestroy } from '@angular/core';
import { Observable } from "rxjs";
import { PostService } from '../post.service';
import { Post } from '../models/post';
import { ActivatedRoute, Router, RouterEvent, NavigationEnd } from '@angular/router';
import { Subject } from 'rxjs';
import{ takeUntil, filter }from'rxjs/operators';

@Component({
  selector: 'app-search-posts',
  templateUrl: './search-posts.component.html',
  styleUrls: ['./search-posts.component.css']
})
export class SearchPostsComponent implements OnInit, OnDestroy {
  posts: Post;
  searchParam: string;
  public destroyed = new Subject<any>();
  constructor(private postservice: PostService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    // this.searchParam = sessionStorage.getItem("searchParam");
    console.log(this.route.snapshot.params.search);
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

  fetchData():void {
    this.postservice.getPostsByTitle(this.route.snapshot.params.search).subscribe(u => {
      this.posts = u;
    });
  }

}
