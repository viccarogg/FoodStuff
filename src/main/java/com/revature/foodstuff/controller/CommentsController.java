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

import com.revature.foodstuff.model.Comments;
import com.revature.foodstuff.repository.CommentsRepository;

@RestController
@RequestMapping("/api")
public class CommentsController {

	@Autowired
    private CommentsRepository commentsRepository;
	
	 @GetMapping("/comments")
	    public List<Comments> getAllComments() {
	        return commentsRepository.findAll();
	    }
	 
	 @GetMapping("/comments/{id}")
	    public List<Comments> getCommentsByPostId(@PathVariable(value = "id") Iterable<Long> postId) {
		 
		return commentsRepository.findAllById(postId);
	}
	       
		 
		 
	 
	 
	 @PostMapping("/createComment")
	    public Comments createComment(@Valid @RequestBody Comments comment) {
	        return commentsRepository.save(comment);
	    }
	 
	 
//	 @DeleteMapping("/comment/{id}")
//	    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId){
//	         
//	    }
	
}
