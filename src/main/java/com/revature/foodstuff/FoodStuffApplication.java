package com.revature.foodstuff;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.revature.foodstuff.model.Comments;
import com.revature.foodstuff.repository.CommentsRepository;

@SpringBootApplication
public class FoodStuffApplication {

	@Autowired
	DataSource dataSource;

	@Autowired
	CommentsRepository commentsRepository; 

	public static void main(String[] args) {
		SpringApplication.run(FoodStuffApplication.class, args);

	}

}
