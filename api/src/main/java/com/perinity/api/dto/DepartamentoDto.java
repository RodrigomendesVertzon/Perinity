package com.perinity.api.dto;

import com.perinity.domain.model.Departamento;

public class DepartamentoDto {

	private Departamento departamento;
	private int quantidadePessoas;
	private int quantidadeTarefas;
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	public int getQuantidadePessoas() {
		return quantidadePessoas;
	}
	public void setQuantidadePessoas(int quantidadePessoas) {
		this.quantidadePessoas = quantidadePessoas;
	}
	public int getQuantidadeTarefas() {
		return quantidadeTarefas;
	}
	public void setQuantidadeTarefas(int quantidadeTarefas) {
		this.quantidadeTarefas = quantidadeTarefas;
	}

}
