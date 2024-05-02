package com.schedule.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schedule.demo.entity.VotoEntity;
import com.schedule.demo.service.VotoService;

@RestController
@RequestMapping("/voto")
public class VotoController {
	
	@Autowired
	private VotoService service;
	
	@PostMapping("/create")
	public VotoEntity createVoto(@RequestBody VotoEntity voto) {
		return service.createVoto(voto);
	}
	
	
}
