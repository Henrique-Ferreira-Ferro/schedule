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

import com.schedule.demo.entity.UserEntity;
import com.schedule.demo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping("/{id}")
	public Optional<UserEntity> getUser(@PathVariable Long id) {
		return service.getUser(id);
	}

	@PostMapping("/create")
	public UserEntity createUser(@RequestBody UserEntity user) {
		return service.createUser(user);

	}

	@GetMapping
	public List<UserEntity> listUsers() {
		return service.findUsers();
	}
	
	@PutMapping("/update/{id}")
	public UserEntity updateUser(@PathVariable Long id, @RequestBody UserEntity user) {
		return service.updateUser(id,user);
	}
	
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable Long id){
		return service.deleteUser(id);
	}
	
	
}
