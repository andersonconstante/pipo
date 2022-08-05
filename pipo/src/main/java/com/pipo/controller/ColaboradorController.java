package com.pipo.controller;

import java.rmi.ServerException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pipo.modelo.Colaborador;
import com.pipo.repository.ColaboradorRepository;

@RestController
@RequestMapping("colaborador")
public class ColaboradorController {
	
	@Autowired
	private ColaboradorRepository colaboradorRepository;
	
	@GetMapping(value = "" )
	public ResponseEntity<List<Colaborador>> listarColaboradores () {		
	
		
			List<Colaborador> colaboradores = colaboradorRepository.findAll();	
			
			if(colaboradores.isEmpty()) {
				ResponseEntity.notFound();
			}
			return  ResponseEntity.ok(colaboradores.stream()
					  .collect(Collectors.toList()));
			
	}
	
	@PostMapping(path = "/cadastrar")
	public ResponseEntity<Colaborador> cadastrar(@RequestBody Colaborador novoColaborador) throws ServerException {
		Colaborador colaborador = colaboradorRepository.save(novoColaborador);
	    if (colaborador == null) {
	        throw new ServerException("Não foi possível cadastrar o Colaborador, dados inválidos!");
	    } else {
	        return new ResponseEntity<>(colaborador, HttpStatus.CREATED);
	    }
	}
}
