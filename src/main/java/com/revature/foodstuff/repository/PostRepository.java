package com.revature.foodstuff.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.revature.foodstuff.model.Post;
import com.revature.foodstuff.model.User;

public interface PostRepository extends JpaRepository<Post, Long> {

	// this method finds posts based on the user that created them
	@Query(value="SELECT * FROM POSTS p WHERE p.user_id = :userId",
		   nativeQuery=true)
    public List<Post> findByUserId(@Param("userId") Long userId);
	
	// this method finds posts based on the user that saved them
	@Query(value="select p.post_id, p.title, p.content, p.flagged, p.user_id from POSTS p " + 
			"inner join USER_SAVED_POSTS s " + 
			"on p.post_id = s.post_id " + 
			"where s.user_id = :userId",
			nativeQuery=true)
	public List<Post> findByUserSaves(@Param("userId") Long userId);

	
	// this method finds posts based search pattern
	@Query(value="SELECT * FROM POSTS p WHERE LOWER(p.title) Like %:pattern%",
		   nativeQuery=true)
    public List<Post> findByTitle(@Param("pattern") String pattern);
	
}
