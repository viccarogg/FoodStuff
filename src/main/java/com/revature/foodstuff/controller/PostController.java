package com.revature.foodstuff.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.revature.foodstuff.model.Post;
import com.revature.foodstuff.repository.PostRepository;

@RestController
@CrossOrigin("*")
//@CrossOrigin("http://localhost:4200")
@RequestMapping("/api")
public class PostController {
	@Autowired
	private PostRepository postRepository;

	@GetMapping("/posts")
	public List<Post> getAllPosts() {
		return postRepository.findAll();
	}

	@GetMapping("/posts/{id}")
	public ResponseEntity<Post> getPostById(@PathVariable(value = "id") Long postId) 
		throws ResourceNotFoundException {
		Post post = postRepository.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post not found for this id : " + postId));
		return ResponseEntity.ok().body(post);
	}

	@GetMapping("/posts/user/{id}")
	public List<Post> getPostsByUser(@PathVariable(value = "id") Long userId) {
		return postRepository.findByUserId(userId);
	}
	
	@GetMapping("/posts/saved/{id}")
	public List<Post> getSavedPostsForUser(@PathVariable(value="id") Long userId) {
		return postRepository.findByUserSaves(userId);
	}
	
	@PostMapping("/posts")
	public Post createPost(@Valid @RequestBody Post post) {
		return postRepository.save(post);
	}
	
	@PutMapping("/posts/{id}")
	public ResponseEntity<Post> updatePost(@PathVariable(value="id") Long postId,
				@Valid @RequestBody Post postDetails) throws ResourceNotFoundException {
		Post post = postRepository.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post not found for this id : " + postId));
		post.setContent(postDetails.getContent());
		post.setFlag(postDetails.getFlag());
		post.setTitle(postDetails.getTitle());
		Post updatedPost = postRepository.save(post);
		return ResponseEntity.ok(updatedPost);
	}
	
	@DeleteMapping("/posts/{id}")
	public Map<String, Boolean> deletePost(@PathVariable(value = "id") Long postId)
			throws ResourceNotFoundException {
		Post post = postRepository.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post not found for this id :: " + postId));
		postRepository.delete(post);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
