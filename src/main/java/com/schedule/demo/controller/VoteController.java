package com.schedule.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schedule.demo.dto.VotingResultDTO;
import com.schedule.demo.entity.VoteEntity;
import com.schedule.demo.service.VoteService;

@RestController
@RequestMapping("/vote")
public class VoteController {
	
	@Autowired
	private VoteService service;
	
	@PostMapping("/create")
	public VoteEntity createVoto(@RequestBody VoteEntity voto) {
		return service.createVote(voto);
	}
	
	
	@GetMapping("/{id}")
	public Optional<VoteEntity> findVoteById(@PathVariable Long id){
		return service.findVoteById(id);
	}
	
//	@GetMapping("result/{id}")
//	public VotingResultDTO resultVoting(@PathVariable Long id) {
//		return null;
//	}
	
}
