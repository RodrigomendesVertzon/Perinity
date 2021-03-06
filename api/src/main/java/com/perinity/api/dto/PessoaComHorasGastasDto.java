package com.perinity.api.dto;

import java.util.List;

import com.perinity.domain.model.Pessoa;
import com.perinity.domain.model.Tarefa;

public class PessoaComHorasGastasDto {

	private Pessoa pessoa;
	private List<Tarefa> tarefa;
	private int mediaHorasGastasPorTarefa;
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public List<Tarefa> getTarefa() {
		return tarefa;
	}
	public void setTarefa(List<Tarefa> tarefa) {
		this.tarefa = tarefa;
	}
	public int getMediaHorasGastasPorTarefa() {
		return mediaHorasGastasPorTarefa;
	}
	public void setMediaHorasGastasPorTarefa(int mediaHorasGastasPorTarefa) {
		this.mediaHorasGastasPorTarefa = mediaHorasGastasPorTarefa;
	}
	
	
	
}