package com.schedule.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schedule.demo.entity.VotoEntity;
import com.schedule.demo.repository.VotoRepository;

@Service
public class VotoService {
	
	@Autowired
	private VotoRepository repository;
	
	
	public VotoEntity createVoto(VotoEntity voto) {
		return repository.save(voto);
	}
	
	
}
