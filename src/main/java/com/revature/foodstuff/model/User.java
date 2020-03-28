package com.revature.foodstuff.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.transaction.annotation.Transactional;


@Entity
@Table(name = "USERS")
@Transactional
public class User {
	
	
	@Id
	@Column(name ="user_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;

	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "email")
	private String email;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "userId", fetch=FetchType.LAZY)
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
	

	public User() { }

	public User(Long userId, String username, String password, String email) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.email = email;
	}

	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
