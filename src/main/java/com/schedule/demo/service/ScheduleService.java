package com.schedule.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schedule.demo.entity.ScheduleEntity;
import com.schedule.demo.exceptions.BadRequestException;
import com.schedule.demo.repository.ScheduleRepository;

@Service
public class ScheduleService {
	
	@Autowired
	private ScheduleRepository repository;
	
	
	public ScheduleEntity createSchedule(ScheduleEntity pauta) {
		if(pauta.getDescription().isEmpty()) {
			throw new BadRequestException("Por favor, coloque uma descrição para a pauta!");
		}
		return repository.save(pauta);
	}
	
	public Optional<ScheduleEntity> findScheduleById(Long id) {
		return repository.findById(id);
	}
	
	
	
}
