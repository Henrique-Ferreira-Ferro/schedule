package com.schedule.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class UsuarioController {
	
	@GetMapping
	public String getHello() {
		return "Hello";
	}
	
}
