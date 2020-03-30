import { Post } from './models/post';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PostService {


  private baseUrl = 'http://localhost:9090/api/posts';

  constructor(private http: HttpClient) { }

  getAllPosts(): Observable<any> {
    return this.http.get(this.baseUrl);
  }

  getPost(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`)
  }

  getPostsByUser(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/user/${id}`)
  }

  getSavedPostsForUser(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/saved/${id}`)
  }

  createPost(post: Post): Observable<Object> {
    return this.http.post(this.baseUrl, post);
  }

  updatePost(id: number, post: Post): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, post);
  }

  deletePost(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

  // async getPostsByFollowing(followees: any) {
  //   let result = [];
  //   for (let user of followees) {
  //     console.log('"user"')
  //     const data = await this.getPostsByUser(user.userId).toPromise();
  //     // subscribe(posts => {
  //     //   console.log(posts)
  //     console.log(data)
  //     result = result.concat(data);
  //   }
  //   console.log(result)  
  //   return result;
  // }

  getPostsByTitle(searchstr: string): Observable<any> {
    //alert('this is in');
    alert(searchstr)
    return this.http.get(`http://localhost:9090/api/posts/search/${searchstr}`)
  }


}
