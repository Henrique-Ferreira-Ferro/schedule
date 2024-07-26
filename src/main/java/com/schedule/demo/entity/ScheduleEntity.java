package com.schedule.demo.entity;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

@Entity
public class ScheduleEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size(min = 5, max = 300)
	private String description;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDateTime term;
	
	public ScheduleEntity(){
		
	}
	
	public ScheduleEntity(Long id, String descricao, LocalDateTime prazo) {
		this.id = id;
		this.description = descricao;
		this.term = prazo;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String descricao) {
		this.description = descricao;
	}
	
	public LocalDateTime getTerm() {
		return this.term;
	}
	
	public void setTerm(LocalDateTime prazo) {
		this.term = prazo;
	}
	
}
