package com.schedule.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schedule.demo.entity.ScheduleEntity;
import com.schedule.demo.service.ScheduleService;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {
	
	@Autowired
	private ScheduleService service;
	
	
	@PostMapping("/create")
	public ScheduleEntity createSchedule(@RequestBody ScheduleEntity pauta) {
		return service.createSchedule(pauta);
	}
	
	@GetMapping("/{id}")
	public Optional<ScheduleEntity> findScheduleById(@PathVariable Long id){
		return service.findScheduleById(id);
	}
	
	
}
