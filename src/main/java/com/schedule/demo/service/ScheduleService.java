package com.schedule.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schedule.demo.entity.ScheduleEntity;
import com.schedule.demo.repository.PautaRepository;

@Service
public class ScheduleService {
	
	@Autowired
	private PautaRepository repository;
	
	
	public ScheduleEntity createSchedule(ScheduleEntity pauta) {
		return repository.save(pauta);
	}
	
	public Optional<ScheduleEntity> findScheduleById(Long id) {
		return repository.findById(id);
	}
	
	
	
}
