package com.revature.foodstuff.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="comments")
public class Comments {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="comment_id")
	int commentId;
	@Column(name="user_id")
	int userId;
	@Column(name="comments")
	String comments;
	@Column(name="flagged")
	int flag;
	
	 
	
	
	public Comments(int userId, String comments, int flag) {
		this.userId = userId;
		this.comments = comments;
		this.flag = flag;
	}
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	
	
	
	
	

}
