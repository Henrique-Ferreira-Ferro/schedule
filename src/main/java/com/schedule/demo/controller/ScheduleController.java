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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {
	
	@Autowired
	private ScheduleService service;
	
	@Operation(summary = "Criação de uma pauta", description="Funcionalidade responsavel por criar uma pauta")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Pauta criada com sucesso!",
					content = @Content(mediaType = "application/json",
					schema = @Schema(implementation = ScheduleEntity.class))),
			@ApiResponse(responseCode = "400", description = "Por favor, coloque uma descrição para a pauta!")
	})
	@PostMapping("/create")
	public ScheduleEntity createSchedule(@RequestBody ScheduleEntity pauta) {
		return service.createSchedule(pauta);
	}
	
	@Operation(summary = "Buscar pauta por id", description = "Essa funcionalidade é responsavel por buscar uma pauta pelo ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Pauta encontrada com sucesso",
					content = @Content(mediaType = "application/json",
					schema = @Schema(implementation = ScheduleEntity.class)
			)
		),
			@ApiResponse(responseCode = "400", description = "Não foi possivel encontrar a pauta!")
	})
	@GetMapping("/{id}")
	public Optional<ScheduleEntity> findScheduleById(@PathVariable Long id){
		return service.findScheduleById(id);
	}
	
	// Criar sessaao para a pauta :v
	
	
	@PostMapping("/session")
	public ScheduleEntity insertSession(@RequestBody ScheduleEntity schedu){
		return service.insertSession(schedu);
	}
	
	
	
}
