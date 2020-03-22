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

//	public void run(String... args) {
//
//		System.out.println("DATASOURCE = " + dataSource);
//		String comment = "What kind of sauce are you using?";
//		Comments newComment = new Comments();
//		newComment.setComments(comment);
//		newComment.setFlag(0);
//		newComment.setUserId(2);
//		
//		commentsRepository.save(newComment);
//		
//	}
//		
//		
//		System.out.println("\n1.findAll()...");
//	    for (Comments comments : commentsRepository.findFlagged(1)) {
//	        System.out.println(comments);
//	    }
//
//	}
}
