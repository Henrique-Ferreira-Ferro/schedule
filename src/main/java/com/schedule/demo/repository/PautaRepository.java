package com.schedule.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.schedule.demo.entity.ScheduleEntity;

@Repository
public interface PautaRepository extends JpaRepository<ScheduleEntity, Long>{
	
}
