package com.perinity.api.dto;

import java.util.List;

import com.perinity.domain.model.Pessoa;

public class PessoaDto {

	private List<Pessoa> pessoas;
	private double totalHorasGastas;
	
	
	public List<Pessoa> getPessoas() {
		return pessoas;
	}
	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
	public double getTotalHorasGastas() {
		return totalHorasGastas;
	}
	public void setTotalHorasGastas(double totalHorasGastas) {
		this.totalHorasGastas = totalHorasGastas;
	}
	
	
}
