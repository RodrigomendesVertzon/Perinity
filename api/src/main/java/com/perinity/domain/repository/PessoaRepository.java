package com.perinity.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perinity.domain.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}