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
public class Followers {
	 private long affiliationID;
	 private int followerID;
	 private int followeeID;

	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	public long getAffiliationID() {
		return affiliationID;
	}

	  
	public void setAffiliationID(long affiliationID) {
		this.affiliationID = affiliationID;
	}
	
	
	  @Column(name = "follower_ID", nullable = false)
	public int getFollowerID() {
		return followerID;
	}

	  
	public void setFollowerID(int followerID) {
		this.followerID = followerID;
	}
	
	
	  @Column(name = "followee_ID", nullable = false)
	public int getFolloweeID() {
		return followeeID;
	}

	public void setFolloweeID(int followeeID) {
		this.followeeID = followeeID;
	} 
	  
	  
	  
	  
}
