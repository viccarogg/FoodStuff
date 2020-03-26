import { User } from './models/user';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ServiceUsersService {

  private baseUrl = 'http://localhost:9090/api';

  constructor(private http: HttpClient) { }

  login(credentials: {username: string, password: string}): Observable<any> {
    return this.http.post(`${this.baseUrl}/login`, credentials );
  }

  getAllUsers(): Observable<any> {
    return this.http.get(`${this.baseUrl}/users`);
  }


  getUserById(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/users/${id}`);
  }

  createUser(user: User): Observable<Object> {
    return this.http.post(`${this.baseUrl}/users`, user);
  }

  getFollowers(userid: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/users/followers/${userid}`);
  }

  getFollowees(userId: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/users/followees/${userId}`);
  }

  follow(body: {followId: number, currentUserId: number}): Observable<any> {
    return this.http.post(`${this.baseUrl}/follow`, body, { responseType: 'text' });
  }

  unfollow(followId: number, currentUserId: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/follow/${currentUserId}/${followId}`, { responseType: 'text' });
  }

  savePost(body: {userId: number, postId: number}): Observable<any> {
    return this.http.post(`${this.baseUrl}/save`, body, { responseType: 'text' });
  }

  unSavePost(userId: number, postId: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/saved/${userId}/${postId}`, { responseType: 'text' });
  }

  updateUser(id: number, user: User): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, user);
  }

  deleteUser(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }




}
