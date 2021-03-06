package com.perinity.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.perinity.domain.model.Pessoa;
import com.perinity.domain.model.Tarefa;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Integer> {

	List<Tarefa> findTop3ByIdPessoaIsNullOrderByPrazoAsc();
	
	@Query("SELECT sum(t.duracao) from Tarefa t")
	public double tempoTotalTarefas();
	
	@Query("SELECT avg(t.duracao) from Tarefa t where id_pessoa = :id")
	public int mediaTempoTarefas(int id);
	
	List<Tarefa> findAllByIdDepartamento(int id);
	
	List<Tarefa> findAllByIdPessoa(Pessoa pessoa);
}
