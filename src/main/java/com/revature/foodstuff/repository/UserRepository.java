package com.revature.foodstuff.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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
	
}
