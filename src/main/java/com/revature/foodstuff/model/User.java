package com.revature.foodstuff.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class User {
	
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;

	@Column(name = "username")
	private String userName;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "email")
	private String email;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
	private List<Post> posts = new ArrayList<Post>();

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "USER_SAVED_POSTS", 
	joinColumns = { @JoinColumn(name = "USER_ID") }, 
	inverseJoinColumns = { @JoinColumn(name = "POST_ID") })
	private List<Post> savedPost = new ArrayList<Post>();
	
	@ManyToMany(cascade = CascadeType.ALL)
	 @JoinTable(name = "FOLLOWERS", 
	 joinColumns = { @JoinColumn(name = "USER_ID") }, 
	 inverseJoinColumns = { @JoinColumn(name = "FOLLOWER_ID") })
	private List<User> followers = new ArrayList<User>();
	
	@ManyToMany(mappedBy="followers")
	private List<User> following = new ArrayList<User>();
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
