package com.revature.foodstuff.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//testing 
@Entity
@Table(name = "Affiliation")
public class Follower {
	 private Long affiliationID;
	 private User followerID;
	 private User followeeID;

	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	public Long getAffiliationID() {
		return affiliationID;
	}

	  
	public void setAffiliationID(Long affiliationID) {
		this.affiliationID = affiliationID;
	}
	
	
	  @Column(name = "follower_ID", nullable = false)
	public User getFollowerID() {
		return followerID;
	}

	  
	public void setFollowerID(User followerID) {
		this.followerID = followerID;
	}
	
	
	  @Column(name = "followee_ID", nullable = false)
	public User getFolloweeID() {
		return followeeID;
	}

	public void setFolloweeID(User followeeID) {
		this.followeeID = followeeID;
	} 
	  
	  
	  
	  
}
