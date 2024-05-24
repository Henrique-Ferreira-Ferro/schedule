package com.schedule.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schedule.demo.dto.VotingResultDTO;
import com.schedule.demo.entity.VoteEntity;
import com.schedule.demo.repository.VoteRepository;

@Service
public class VoteService {
	
	@Autowired
	private VoteRepository repository;
	
	
	public VoteEntity createVote(VoteEntity voto) {
		return repository.save(voto);
	}
	
	public Optional<VoteEntity> findVoteById(Long id){
		return repository.findById(id);
	}
	
	public VotingResultDTO resultVotacao(Long id) {
		// Logica precisa ser implementada
		return null;
	}
	
	
}
