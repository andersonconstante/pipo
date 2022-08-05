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

import com.pipo.modelo.Empresa;
import com.pipo.repository.EmpresaRepository;


@RestController
@RequestMapping("empresa")
public class EmpresaController {

	@Autowired
	private EmpresaRepository empresaRepository;
	
	@GetMapping(value = "" )
	public ResponseEntity<List<Empresa>> listarClientes () {		
	
		
			List<Empresa> clientes = empresaRepository.findAll();	
			
			if(clientes.isEmpty()) {
				ResponseEntity.notFound();
			}
			return  ResponseEntity.ok(clientes.stream()
					  .collect(Collectors.toList()));
			
	}
	
	@PostMapping(path = "/cadastrar")
	public ResponseEntity<Empresa> cadastrar(@RequestBody Empresa novaEmpresa) throws ServerException {
		Empresa empresa = empresaRepository.save(novaEmpresa);
	    if (empresa == null) {
	        throw new ServerException("Não foi possível cadastrar o Cliente, dados inválidos!");
	    } else {
	        return new ResponseEntity<>(empresa, HttpStatus.CREATED);
	    }
	}
	
	
}
