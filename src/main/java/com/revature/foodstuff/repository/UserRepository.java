package com.revature.foodstuff.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.revature.foodstuff.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	@Query(value="SELECT * FROM USERS WHERE username= :username AND password = :password",
		   nativeQuery=true)
    public User loginUser(@Param("username") String userName, @Param("password") String password);
	
	@Query(value="select U.USER_ID, U.USERNAME, u.password, u.email from USERS u " + 
			"inner join FOLLOWERS f " + 
			"on u.user_id = f.follower_id " + 
			"where f.user_id = :userId", nativeQuery = true)
	public List<User> getFollowers(@Param("userId") Long userId);
	
	@Query(value="select U.USER_ID, U.USERNAME, u.password, u.email from USERS u " + 
			"inner join FOLLOWERS f " + 
			"on u.user_id = f.user_id " + 
			"where f.follower_id = :userId", nativeQuery=true)
	public List<User> getFollowees(@Param("userId") Long userId);
	
	@Transactional
	@Modifying(clearAutomatically= true)
	@Query(value="insert into user_saved_posts VALUES (:userId, :postId)", nativeQuery=true)
	public void savePost(@Param("userId") Long userId, @Param("postId") Long postId);
	
	
	@Transactional
	@Modifying(clearAutomatically= true)
	@Query(value="insert into followers VALUES (:followId, :currentUserId)", nativeQuery=true)
	public void follow(@Param("followId") Long followId, @Param("currentUserId") Long currentUserId);


	@Transactional
	@Modifying(clearAutomatically=true)
	@Query(value="delete from user_saved_posts where user_id= :userId AND post_id= :postId", nativeQuery = true)
	public void deleteSaved(@Param("userId") Long userId, @Param("postId") Long postId);

	@Transactional
	@Modifying(clearAutomatically=true)
	@Query(value="delete from followers where follower_id= :currentUserId  AND user_id= :followId ", nativeQuery = true)
	public void unfollow(@Param("currentUserId") Long currentUserId, @Param("followId") Long followId);
}
