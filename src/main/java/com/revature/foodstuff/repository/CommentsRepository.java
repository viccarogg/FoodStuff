package com.revature.foodstuff.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.revature.foodstuff.model.Comments;

public interface CommentsRepository extends JpaRepository<Comments, Long> {
	
	List<Comments> findByCommentId(int commentId);
    
    @Query("select * from Comments where flagged >= 1;")
    public List<Comments> findFlagged(int flag);


}
