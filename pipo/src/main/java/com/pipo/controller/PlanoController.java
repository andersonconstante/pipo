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
import com.pipo.modelo.Plano;
import com.pipo.repository.PlanoRepository;

@RestController
@RequestMapping("plano")
public class PlanoController {

	@Autowired
	private PlanoRepository planoRepository;
	
	@GetMapping(value = "" )
	public ResponseEntity<List<Plano>> listarPlanos () {		
	
		
			List<Plano> Planos = planoRepository.findAll();	
			
			if(Planos.isEmpty()) {
				ResponseEntity.notFound();
			}
			return  ResponseEntity.ok(Planos.stream()
					  .collect(Collectors.toList()));
			
	}
	
	@PostMapping(path = "/cadastrar")
	public ResponseEntity<Plano> cadastrar(@RequestBody Plano novoPlano) throws ServerException {
		Plano plano = planoRepository.save(novoPlano);
	    if (plano == null) {
	        throw new ServerException("Não foi possível cadastrar o Plano, dados inválidos!");
	    } else {
	        return new ResponseEntity<>(plano, HttpStatus.CREATED);
	    }
	}
}
