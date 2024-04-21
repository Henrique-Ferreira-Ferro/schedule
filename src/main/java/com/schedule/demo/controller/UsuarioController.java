package com.schedule.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schedule.demo.entity.UsuarioEntity;
import com.schedule.demo.service.UsuarioService;

@RestController
@RequestMapping("/user")
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	@GetMapping("{id}")
	public Optional<UsuarioEntity> getUser(@PathVariable Long id) {
		return service.getUser(id);
	}

	@PostMapping("/create")
	public UsuarioEntity createUser(@RequestBody UsuarioEntity user) {
		return service.createUser(user);

	}

	@GetMapping
	public List<UsuarioEntity> listUser() {
		return service.findUsers();
	}
	
	//Preciso consertar
	@PutMapping("/update/{id}")
	public UsuarioEntity updateUser(@PathVariable Long id, @RequestBody UsuarioEntity user) {
		return service.updateUser(id,user);
	}
	
	@DeleteMapping("{id}")
	public List<UsuarioEntity> deleteUser(@PathVariable Long id){
		return service.deleteUser(id);
	}
	
	
}
