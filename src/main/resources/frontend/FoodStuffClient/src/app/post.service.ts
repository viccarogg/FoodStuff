import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PostService {


  private baseUrl = 'http://localhost:9090/api/posts';

  constructor(private http: HttpClient) { }

  getAllPosts() {
    return this.http.get(this.baseUrl);
  }

  getPost(id:number) : Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`)
  }

  getPostsByUser(id:number) : Observable<any> {
    return this.http.get(`${this.baseUrl}/user/${id}`)
  }

  getSavedPostsForUser(id:number) : Observable<any> {
    return this.http.get(`${this.baseUrl}/saved/${id}`)
  }

  createPost(post:Object) : Observable<Object> {
    return this.http.post(this.baseUrl, post);
  }

  updatePost(id:number, post:Object) : Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, post);
  }

  deletePost(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }
}
