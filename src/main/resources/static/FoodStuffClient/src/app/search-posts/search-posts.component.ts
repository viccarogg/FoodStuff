import { Component, OnInit } from '@angular/core';
import { Observable } from "rxjs";
import {PostService} from '../post.service';
import { Post } from '../models/post';
import { ActivatedRoute  } from '@angular/router';

@Component({
  selector: 'app-search-posts',
  templateUrl: './search-posts.component.html',
  styleUrls: ['./search-posts.component.css']
})
export class SearchPostsComponent implements OnInit {
  posts: any;
  searchParam:string;
  constructor(private postservice: PostService,private router: ActivatedRoute) { }

  ngOnInit(): void {
   alert(this.router.snapshot.params.search);
   this.postservice.getPostsByTitle(this.router.snapshot.params.search).subscribe(u => {
    this.posts = u;
  });
  }
  

}
