package com.revature.foodstuff.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



//testing


@Entity
@Table(name = "Saved")
public class Saved {
	 private long savedID;
	 private int postID;
	 private int userID;
	
	 
	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	 public long getSavedID() {
		return savedID;
	}
	  
	  
	public void setSavedID(long savedID) {
		this.savedID = savedID;
	}
	
	@Column(name = "post_ID", nullable = false)
	public int getPostID() {
		return postID;
	}
	public void setPostID(int postID) {
		this.postID = postID;
	}
	
	@Column(name = " user_ID", nullable = false)
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	 
	 
	 
	 
}
