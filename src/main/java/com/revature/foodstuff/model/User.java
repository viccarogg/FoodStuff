package com.revature.foodstuff.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	int userId;

}
