package com.schedule.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schedule.demo.dto.VotingResultDTO;
import com.schedule.demo.entity.VoteEntity;
import com.schedule.demo.service.VoteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/vote")
public class VoteController {
	
	@Autowired
	private VoteService service;
	
	
	@Operation(summary = "realizar um voto", description = "Funcionalidade responsavel por realizar um voto")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Voto realizado com sucesso",
			content = @Content(mediaType = "application/json",
			schema = @Schema(implementation = VoteEntity.class)	
				)
			),
			@ApiResponse(responseCode="403", description="A pauta está fechada!"),
			@ApiResponse(responseCode="403", description="Você não pode votar novamente :D")
	})
	@PostMapping("/create")
	public VoteEntity createVoto(@RequestBody VoteEntity voto) {
		return service.createVote(voto);
	}
	
	@Operation(summary = "Pesquisar um voto", description = "Funcionalidade responsavel por realizar a pesquisa de um voto feito")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Voto encontrado com sucesso",
					content = @Content(mediaType = "application/json",
					schema = @Schema(implementation = VoteEntity.class)
			)
		),
		@ApiResponse(responseCode = "400", description = "Voto não encontrado")
	})
	@GetMapping("/{id}")
	public Optional<VoteEntity> findVoteById(@PathVariable Long id){
		return service.findVoteById(id);
	}
	
	
	@Operation(summary = "verificar resultado da votação")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Pauta aprovada/reprovada",
					content = @Content(mediaType = "application/json",
					schema = @Schema(implementation = VoteEntity.class)
				)
			),
			@ApiResponse(responseCode = "403", description = "Votação em andamento!")
	})
	@GetMapping("result/{id}")
	public VotingResultDTO resultVoting(@PathVariable Long id) {
		return service.resultVotacao(id);
	}
	
}
