package com.schedule.demo.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schedule.demo.dto.VotingResultDTO;
import com.schedule.demo.entity.ScheduleEntity;
import com.schedule.demo.entity.VoteEntity;
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
		Date date = new Date();

		// Buscando a pauta que o cara votou :D
		Optional<ScheduleEntity> shedu = scheduRepository.findById(voto.getIdSchedule());
		if (scheduRepository.existsById(voto.getIdSchedule()) && userRepository.existsById(voto.getIdUser())) {

			VoteEntity vote = voteRepository.findByIdUserAndIdSchedule(voto.getIdUser(), voto.getIdSchedule());

			/*
			 * Se o voto não existir, vamos deixar o usuario votar para conseguir votar,
			 * pauta dentro do prazo
			 */

			// Não esta no banco

			if (vote == null) {

				// se a data atual, for anterior do prazo, votação em andamento
				if (date.before(shedu.get().getTerm())) {
					return voteRepository.save(voto);

				}
				throw new RuntimeException("A pauta está fechada!");

			}
			throw new RuntimeException("Você não pode votar novamente :D");
		}

		return voteRepository.save(voto);
	}

	public Optional<VoteEntity> findVoteById(Long id) {
		return voteRepository.findById(id);
	}

	public VotingResultDTO resultVotacao(Long idUser, Long idSchedule) {

		return null;
	}

}
