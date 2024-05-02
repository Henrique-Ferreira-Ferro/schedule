package com.schedule.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schedule.demo.entity.PautaEntity;
import com.schedule.demo.service.PautaService;

@RestController
@RequestMapping("/pauta")
public class PautaController {
	
	@Autowired
	private PautaService service;
	
	
	@PostMapping("/create")
	public PautaEntity createPauta(@RequestBody PautaEntity pauta) {
		return service.createPauta(pauta);
	}
	
	
}
