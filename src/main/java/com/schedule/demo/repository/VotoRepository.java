package com.schedule.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.schedule.demo.entity.VoteEntity;

public interface VotoRepository extends JpaRepository<VoteEntity, Long>{

}
