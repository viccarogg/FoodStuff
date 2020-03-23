package com.revature.foodstuff.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.foodstuff.model.Comment;
import com.revature.foodstuff.repository.CommentRepository;

@RestController
@RequestMapping("/api")
public class CommentController {

	@Autowired
    private CommentRepository commentsRepository;
	
	 @GetMapping("/comments")
	    public List<Comment> getAllComments() {
	        return commentsRepository.findAll();
	    }
	 
	 @GetMapping("/comments/{id}")
	    public List<Comment> getCommentsByPostId(@PathVariable(value = "id") Iterable<Long> postId) {
		 
		return commentsRepository.findAllById(postId);
	}
	       
		 
		 
	 
	 
	 @PostMapping("/createComment")
	    public Comment createComment(@Valid @RequestBody Comment comment) {
	        return commentsRepository.save(comment);
	    }
	 
	 
//	 @DeleteMapping("/comment/{id}")
//	    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId){
//	         
//	    }
	
}
