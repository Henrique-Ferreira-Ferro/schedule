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
	private int id;
	@Size(min = 5, max = 300)
	private String descricao;
	@DateTimeFormat(pattern =  "dd/MM/yyyy")
	private Date prazo;
	
	public PautaEntity(){
		
	}
	
	public PautaEntity(int id, String descricao, Date prazo) {
		this.id = id;
		this.descricao = descricao;
		this.prazo = prazo;
	}
	
	public int getId() {
		return this.id;
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
