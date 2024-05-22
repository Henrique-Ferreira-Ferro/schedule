package com.schedule.demo.dto;

public class VotingResultDTO {
	
	private Long idSchedule;
	private int yes;
	private int no;
	private String result;
	
	public VotingResultDTO() {
		
	}

	public VotingResultDTO(Long idPauta, int sim, int nao, String resultado) {
		this.idSchedule = idPauta;
		this.yes = sim;
		this.no = nao;
		this.result = resultado;
	}

	public Long getIdSchedule() {
		return idSchedule;
	}

	public void setIdSchedule(Long idPauta) {
		this.idSchedule = idPauta;
	}

	public int getYes() {
		return yes;
	}

	public void setYes(int sim) {
		this.yes = sim;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int nao) {
		this.no = nao;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String resultado) {
		this.result = resultado;
	}
	
}
