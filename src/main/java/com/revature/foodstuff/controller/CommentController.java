package com.revature.foodstuff.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.foodstuff.exception.ResourceNotFoundException;
import com.revature.foodstuff.model.Comment;
import com.revature.foodstuff.model.Post;
import com.revature.foodstuff.repository.CommentRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
//@CrossOrigin("http://localhost:4200")
public class CommentController {

	@Autowired
	private CommentRepository commentRepository;

	@GetMapping("/comments")
	public List<Comment> getAllComments() {

		List<Comment> comments = commentRepository.findAll();
		return comments;
	}

	@GetMapping("/comments/post/{id}")
	public List<Comment> getCommentsByPostId(@PathVariable(value = "id") Long postId) {
		return commentRepository.findByPostId(postId);
	}

	@PostMapping("/comments")
	public Comment createComment(@Valid @RequestBody Comment comment) {
		return commentRepository.save(comment);
	}

	@PutMapping("/comments/{id}")
	public ResponseEntity<Comment> updateComment(@PathVariable(value = "id") Long commentId,
			@Valid @RequestBody Comment commentDetails) throws ResourceNotFoundException {
		Comment comment = commentRepository.findById(commentId)
				.orElseThrow(() -> new ResourceNotFoundException("Comment not found"));
		comment.setComments(commentDetails.getComments());
		comment.setFlag(commentDetails.getFlag());
		comment.setPost(commentDetails.getPost());
		comment.setUserId(commentDetails.getUserId());
		Comment updatedComment = commentRepository.save(comment);
		return ResponseEntity.ok(updatedComment);
	}

	@DeleteMapping("/comments/id")
	public Map<String, Boolean> deleteComment(@PathVariable(value = "id") Long commentId)
			throws ResourceNotFoundException {
		Comment comment = commentRepository.findById(commentId)
				.orElseThrow(() -> new ResourceNotFoundException("Comment not found"));
		commentRepository.delete(comment);

		Map<String, Boolean> response = new HashMap<>();
		response.put("Deleted", Boolean.TRUE);

		return response;

	}

}
