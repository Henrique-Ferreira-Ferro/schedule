package com.schedule.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schedule.demo.entity.PautaEntity;
import com.schedule.demo.repository.PautaRepository;

@Service
public class PautaService {
	
	@Autowired
	private PautaRepository repository;
	
	
	public PautaEntity createPauta(PautaEntity pauta) {
		return repository.save(pauta);
	}
	
	public Optional<PautaEntity> findPautaById(Long id) {
		return repository.findById(id);
	}
	
	
	
}
