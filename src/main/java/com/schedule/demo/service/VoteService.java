package com.schedule.demo.service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schedule.demo.dto.VotingResultDTO;
import com.schedule.demo.entity.ScheduleEntity;
import com.schedule.demo.entity.VoteEntity;
import com.schedule.demo.exceptions.BadRequestException;
import com.schedule.demo.exceptions.ForbiddenException;
import com.schedule.demo.repository.ScheduleRepository;
import com.schedule.demo.repository.UserRepository;
import com.schedule.demo.repository.VoteRepository;

@Service
public class VoteService {

	@Autowired
	private VoteRepository voteRepository;

	@Autowired
	private ScheduleRepository scheduRepository;

	@Autowired
	private UserRepository userRepository;

	public VoteEntity createVote(VoteEntity voto) {
		LocalDateTime date = LocalDateTime.now();

		// Buscando a pauta que o cara votou :D
		Optional<ScheduleEntity> shedu = scheduRepository.findById(voto.getIdSchedule());
		if (scheduRepository.existsById(voto.getIdSchedule()) && userRepository.existsById(voto.getIdUser())) {

			VoteEntity vote = voteRepository.findByIdUserAndIdSchedule(voto.getIdUser(), voto.getIdSchedule());

			// Não esta no banco

			if (vote == null) {

				// se a data atual, for anterior do prazo, votação em andamento
				if (date.isBefore(shedu.get().getTerm())) {
					return voteRepository.save(voto);

				}
				throw new ForbiddenException("A pauta está fechada!");

			}
			throw new ForbiddenException("Você não pode votar novamente :D");
		}

		throw new ObjectNotFoundException(shedu.get().getId(), ScheduleEntity.class.getSimpleName());
	}

	public Optional<VoteEntity> findVoteById(Long id) {
		Optional<VoteEntity> vote = voteRepository.findById(id);
		if(!vote.isPresent()) {
			throw new BadRequestException("Não foi possivel encontrar o voto realizado");
		}
		return voteRepository.findById(id);
	}

	public VotingResultDTO resultVotacao(Long idSchedule) {

		LocalDateTime date = LocalDateTime.now();

		Optional<ScheduleEntity> shedu = scheduRepository.findById(idSchedule);

		List<VoteEntity> voteList = voteRepository.findByIdSchedule(idSchedule);

		if (date.isBefore(shedu.get().getTerm())) {
			throw new ForbiddenException("Votação em andamento!");
		}

		var yes = 0;
		var no = 0;
		String resultado = "Resultado";

		for (int i = 0; i < voteList.size(); i++) {
			if (voteList.get(i).isVote()) {
				yes++;
			} else {
				no++;
			}
		}
		if (yes > no) {
			resultado = "Pauta aprovada!";
		} else {
			resultado = "Pauta reprovada!";
		}
		
		return new VotingResultDTO(idSchedule,yes,no,resultado);
	}

}
