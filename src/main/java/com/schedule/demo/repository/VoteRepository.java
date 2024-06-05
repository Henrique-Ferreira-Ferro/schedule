package com.schedule.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.schedule.demo.entity.VoteEntity;

public interface VoteRepository extends JpaRepository<VoteEntity, Long>{
	
	// Inicio da logica 
	
	VoteEntity findByIdUserAndIdSchedule(Long idUser,Long idSchedule);
	
}
