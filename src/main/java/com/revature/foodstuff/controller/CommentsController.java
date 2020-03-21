package com.revature.foodstuff.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.foodstuff.model.Comments;
import com.revature.foodstuff.repository.CommentsRepository;

public class CommentsController {

	@Autowired
	CommentsRepository commentsRepository;

	
}
