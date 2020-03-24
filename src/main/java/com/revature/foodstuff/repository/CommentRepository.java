package com.revature.foodstuff.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.revature.foodstuff.model.Comment;
import com.revature.foodstuff.model.Post;

public interface CommentRepository extends JpaRepository<Comment, Long> {
	

	@Query(value="SELECT * FROM COMMENTS c WHERE c.post_id = :postId",
			   nativeQuery=true)
	    public List<Comment> findByPostId(@Param("postId") Long postId);
}
