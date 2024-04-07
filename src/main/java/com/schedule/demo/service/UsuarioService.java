package com.schedule.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schedule.demo.entity.UsuarioEntity;
import com.schedule.demo.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	
	public UsuarioEntity createUser(UsuarioEntity user) {
		return repository.save(user);
		
	}
	
	public Optional<UsuarioEntity> getUser(Long id) {
		return repository.findById(id);
	}
	
	
}
