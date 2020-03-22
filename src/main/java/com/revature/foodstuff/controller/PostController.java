package com.revature.foodstuff.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.foodstuff.model.Post;
import com.revature.foodstuff.repository.PostRepository;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api")
public class PostController {
	@Autowired
	private PostRepository postRepository;

	@GetMapping("/post")
	public List<Post> getAllPosts() {
		return postRepository.findAll();
	}

	@GetMapping("/post/{id}")
	public Post getPostById(@PathVariable(value = "id") Long postId) {
		Optional<Post> postOpt = postRepository.findById(postId);
		if (postOpt.isPresent())
			return postOpt.get();
		else
			return null; // want to do custom response probably, null is bad i think
	}

	/*
	 * @GetMapping("/post/user/{id}") public List<Post>
	 * getPostsByUser(@PathVariable(value="id") Long userId) { return
	 * postRepository.findByUserId(userId); }
	 */

}
