package com.revature.foodstuff.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.foodstuff.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
