package com.schedule.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.schedule.demo.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{
	
	
}
