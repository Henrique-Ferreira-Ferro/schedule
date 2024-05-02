package com.schedule.demo.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

@Entity
public class PautaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size(min = 5, max = 300)
	private String descricao;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date prazo;
	
	public PautaEntity(){
		
	}
	
	public PautaEntity(Long id, String descricao, Date prazo) {
		this.id = id;
		this.descricao = descricao;
		this.prazo = prazo;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Date getPrazo() {
		return this.prazo;
	}
	
	public void setPrazo(Date prazo) {
		this.prazo = prazo;
	}
	
}
