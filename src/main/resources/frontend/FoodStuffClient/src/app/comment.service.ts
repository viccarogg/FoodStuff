import { Injectable } from '@angular/core';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { Observable, Observer } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class CommentService {

  private baseUrl = 'http://localhost:9090/api/comments';

  constructor(private http: HttpClient) { }

  getAllComments(): Observable<object> {
    return this.http.get(`${this.baseUrl}`);
  }

  getCommentsByPostId(postId: number): Observable<object> {
    return this.http.get(`${this.baseUrl}/posts/${postId}`);
  }

  createComment(comment: object): Observable<object> {
    return this.http.get(`${this.baseUrl}`, comment);
  }

  updateComment(commentDetails: object, commentId: number): Observable<object> {
    return this.http.get(`${this.baseUrl}/${commentId}`, commentDetails);
  }

  deleteComment(commentId: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${commentId}`, {responseType: 'text' });
  }


}
