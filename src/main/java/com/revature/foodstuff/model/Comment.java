package com.revature.foodstuff.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;



@Entity
@Table(name = "comments")
@Transactional
//@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="post")
public class Comment {
	
	
	@Id
	@Column(name="comment_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long commentId;
	
	
	
	@OneToOne
	@JoinColumn(name = "user_id")
	//@JsonIdentityReference(alwaysAsId = true)
	private User userId;


	
	//@JsonManagedReference
	@ManyToOne
	@JoinColumn(name="post_id")
	@JsonIdentityReference(alwaysAsId = true)
	private Post post;
	
	
	@Column(name = "comments")
	private String comments;
	
	@Column(name = "flagged")
	private int flag;

	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
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
