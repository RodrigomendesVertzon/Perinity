package com.perinity.domain.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

@Entity
@Table(name="tarefa")
public class Tarefa {
	
	public Tarefa() {
		this.finalizado = false;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="titulo")
	@NonNull
	private String titulo;
	
	@Column(name="descricao")
	@Nullable
	private String descricao;
	
	@Column(name="prazo")
	@NonNull
	private Date prazo;
	
	@OneToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name="id_departamento", nullable=false)
	private Departamento idDepartamento;
	
	@Column(name="duracao")
	private int duracao;
	
	@JoinColumn(name="id_pessoa")
	@ManyToOne(cascade = CascadeType.REFRESH)
	@Nullable
	private Pessoa idPessoa;
	
	
	@Column(name="Finalizado")
	@Nullable
	private boolean finalizado;


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getPrazo() {
		return prazo;
	}
	public void setPrazo(Date prazo) {
		this.prazo = prazo;
	}

	public Departamento getIdDepartamento() {
		return idDepartamento;
	}
	public void setIdDepartamento(Departamento idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public int getDuracao() {
		return duracao;
	}
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public Pessoa getIdPessoa() {
		return idPessoa;
	}
	public void setIdPessoa(Pessoa idPessoa) {
		this.idPessoa = idPessoa;
	}

	public boolean isFinalizado() {
		return finalizado;
	}
	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}

}