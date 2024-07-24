package com.schedule.demo.service;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schedule.demo.entity.ScheduleEntity;
import com.schedule.demo.exceptions.BadRequestException;
import com.schedule.demo.repository.ScheduleRepository;

import jakarta.transaction.Transactional;

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
		Optional<ScheduleEntity> schedu = repository.findById(id);
		if(schedu.isPresent()) {
			return repository.findById(id);
		}else {
			throw new ObjectNotFoundException(id, ScheduleEntity.class.getName());
		}
		
	}
	
	@Transactional
	public ScheduleEntity insertSession(ScheduleEntity schedule) {
		
		var scheduResponse = repository.findById(schedule.getId());
		
		var date = new Date();
		
		if(scheduResponse.isPresent()) {
			if(scheduResponse.get().getTerm() == null) {
				if(schedule.getTerm() != null) {
					scheduResponse.get().setTerm(schedule.getTerm());
					return repository.saveAndFlush(scheduResponse.get());
				}else {
					var calendar = Calendar.getInstance();
					calendar.setTime(date);
					calendar.add(Calendar.MINUTE, 1);
					scheduResponse.get().setTerm(calendar.getTime());
					return repository.save(scheduResponse.get());
				}
			}else {
				throw new BadRequestException("A pauta está fechada");
			}
		}
		throw new ObjectNotFoundException(schedule.getId(), schedule.getClass().getName());
	}
	
	
}
