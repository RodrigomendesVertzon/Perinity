package com.perinity.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.perinity.domain.repository.DepartamentoRepository;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {
	
	@Autowired
	private DepartamentoRepository departamentoRepository;

	@GetMapping
	public ResponseEntity<?> listarTodos() {
		List<?> listaDepartamentos = departamentoRepository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(listaDepartamentos);
	}
}
