import { Component, OnInit } from '@angular/core';
import { NgbModalConfig, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Post } from '../models/post';
import { PostService } from '../post.service'
import { User } from '../models/user';


@Component({
  selector: 'app-create-post',
  templateUrl: './create-post.component.html',
  styleUrls: ['./create-post.component.css'],
  providers: [NgbModalConfig, NgbModal]
})
export class NgbdModalConfig {
  post: Post = new Post();
  userId: User = new User();

  constructor(config: NgbModalConfig, private modalService: NgbModal, private postService: PostService){
    //customize default values of modals used by this component tree
    config.backdrop = 'static';
    config.keyboard = false;
  }
  
 

  open(content){
    this.modalService.open(content);
  }

  save() {

    this.userId.userId = parseInt(sessionStorage.getItem("currentUserId"));
    this.post.userId = this.userId;
    console.log(this.userId);

    //don't really know how to use this so I may have stuff we don't need in it
    this.postService.createPost(this.post)
    .subscribe(data => {console.log(data)
      }, error => {
      console.log(error);
    })
    console.log(this.post)
  }
  onSubmit() {
    this.save();    
    this.modalService.dismissAll();   

  }
}
// export class CreatePostComponent implements OnInit {

//   constructor() { }

//   ngOnInit(): void {
//   }

// }
