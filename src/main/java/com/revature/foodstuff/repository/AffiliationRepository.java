package com.revature.foodstuff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.foodstuff.model.Follower;


@Repository
public interface AffiliationRepository extends JpaRepository<Follower, Long>{
}
