package com.revature.foodstuff.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.revature.foodstuff.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

	@Query("SELECT p FROM POSTS p WHERE p.USER_ID = :userId")
    public List<Post> findByUserId(@Param("userId") Long userId);
	
	@Query("SELECT postId FROM SAVES_POSTS WHERE user_id = :userId")
	public List<Post> findByUserSaves(@Param("userId") Long userId);

}
