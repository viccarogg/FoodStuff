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
	
}
