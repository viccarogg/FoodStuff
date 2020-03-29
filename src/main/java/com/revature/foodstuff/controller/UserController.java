package com.revature.foodstuff.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.foodstuff.exception.ResourceNotFoundException;
import com.revature.foodstuff.model.Post;
import com.revature.foodstuff.model.User;
import com.revature.foodstuff.repository.UserRepository;

@RestController
@CrossOrigin("*")
//@CrossOrigin("http://localhost:4200")
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/login")
	public ResponseEntity<User> loginUser(@RequestBody User toLogin )
		throws ResourceNotFoundException {
		User user = userRepository.loginUser(toLogin.getUsername(), toLogin.getPassword());
		if(user == null)
			throw new ResourceNotFoundException("No user with these credentials");
		return ResponseEntity.ok().body(user);
	}
	
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserByID(@PathVariable(value = "id") Long userId)
		throws ResourceNotFoundException {
		User user = userRepository.findById(userId)
			.orElseThrow(() -> new ResourceNotFoundException("User not found with this id: " + userId));
		return ResponseEntity.ok().body(user);
	}
	
	// added by ryan  
	@GetMapping("/users/email/{email}")
	public ResponseEntity<User> getUserByEmail(@PathVariable(value = "email") String email)
		throws ResourceNotFoundException {
		User user = userRepository.getEmail(email);
		if(user == null)
			throw new ResourceNotFoundException("User not found with this email: " + email);
		return ResponseEntity.ok().body(user);
	}
	
	

	@PostMapping("/users")
	public User createUser(@RequestBody User user) {
		return userRepository.save(user);
	}
	
	@GetMapping("/users/followers/{id}")
	public List<User> getFollowers(@PathVariable(value = "id") Long userId) {
		List<User> temp = userRepository.getFollowers(userId);
		List<User> result = new ArrayList<User>();
		for(User user : temp) {
			User newUser = new User();
			newUser.setUserId(user.getUserId());
			newUser.setUsername(user.getUsername());
			result.add(newUser);
		}
		return result;
	}
	
	
	@GetMapping("/users/followees/{id}")
	public List<User> getFollowees(@PathVariable(value = "id") Long userId) {
		List<User> temp = userRepository.getFollowees(userId);
		List<User> result = new ArrayList<User>();
		for(User user : temp) {
			User newUser = new User();
			newUser.setUserId(user.getUserId());
			newUser.setUsername(user.getUsername());
			result.add(newUser);
		}
		return result;
	}
	
	
	@PostMapping("/follow")
	public Map<String, Boolean> follow(@RequestBody  Map<String, Long> body){
		userRepository.follow(body.get("followId"), body.get("currentUserId"));
		Map<String, Boolean> response = new HashMap<>();
		response.put("Followed", Boolean.TRUE);
		return response;
		
	} 
	
	@DeleteMapping("/follow/{uid}/{fid}")
	public Map<String, Boolean> unfollow(@PathVariable(value="uid") Long currentUserId, @PathVariable(value="fid") Long followId) {
		userRepository.unfollow(currentUserId, followId);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Unfollowed", Boolean.TRUE);
		return response;
	}
	
	@PostMapping("/save")
	public Map<String, Boolean> savePost(@RequestBody  Map<String, Long> body) {
		
		userRepository.savePost(body.get("userId"), body.get("postId"));
		Map<String, Boolean> response = new HashMap<>();
		response.put("Saved", Boolean.TRUE);
		return response;
	}
	
	@DeleteMapping("/saved/{uid}/{pid}")
	public Map<String, Boolean> deleteSavedPost(@PathVariable(value="uid") Long userId, @PathVariable(value="pid") Long postId) {
		userRepository.deleteSaved(userId, postId);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Post Unsaved", Boolean.TRUE);
		return response;
	}
	
	
	

	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable(value="id") Long userId,
				@Valid @RequestBody User userDetails) throws ResourceNotFoundException {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with this id: " + userId));
		user.setUsername(userDetails.getUsername());
		user.setPassword(userDetails.getPassword());
		user.setEmail(userDetails.getEmail());
		User updatedUser = userRepository.save(user);
		return ResponseEntity.ok(updatedUser);
	}
	
	
	
	@DeleteMapping("/users/{id}")
	public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId)
			throws ResourceNotFoundException {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with this id: " + userId));
		userRepository.delete(user);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
