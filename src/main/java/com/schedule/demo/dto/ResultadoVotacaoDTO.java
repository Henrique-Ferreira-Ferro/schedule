package com.schedule.demo.dto;

public class ResultadoVotacaoDTO {
	
	private Long idPauta;
	private int sim;
	private int nao;
	private String resultado;
	
	public ResultadoVotacaoDTO() {
		
	}

	public ResultadoVotacaoDTO(Long idPauta, int sim, int nao, String resultado) {
		this.idPauta = idPauta;
		this.sim = sim;
		this.nao = nao;
		this.resultado = resultado;
	}

	public Long getIdPauta() {
		return idPauta;
	}

	public void setIdPauta(Long idPauta) {
		this.idPauta = idPauta;
	}

	public int getSim() {
		return sim;
	}

	public void setSim(int sim) {
		this.sim = sim;
	}

	public int getNao() {
		return nao;
	}

	public void setNao(int nao) {
		this.nao = nao;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	
	
	
	
}
