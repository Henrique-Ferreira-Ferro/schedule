package com.schedule.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class VoteEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private boolean vote;
	private Long idShedule;
	private Long idUser;
	
	public VoteEntity() {
		
	}

	public VoteEntity(Long id, boolean vote, Long idPauta, Long idUsuario) {
		super();
		this.id = id;
		this.vote = vote;
		this.idShedule = idPauta;
		this.idUser = idUsuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isVote() {
		return vote;
	}

	public void setVote(boolean vote) {
		this.vote = vote;
	}

	public Long getIdShedule() {
		return idShedule;
	}

	public void setIdShedule(Long idPauta) {
		this.idShedule = idPauta;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUsuario) {
		this.idUser = idUsuario;
	}
	
	
	
}
