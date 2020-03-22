package com.revature.foodstuff.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.foodstuff.model.Comments;
import com.revature.foodstuff.repository.CommentsRepository;

@RestController
@RequestMapping("/comments")
public class CommentsController {

	@Autowired
    private CommentsRepository commentsRepository;
	
	
	
}
