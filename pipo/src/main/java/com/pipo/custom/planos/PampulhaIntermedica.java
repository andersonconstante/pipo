package com.pipo.custom.planos;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;

import com.pipo.modelo.Cliente;
import com.pipo.modelo.Colaborador;
import com.pipo.repository.ClienteRepository;

public class PampulhaIntermedica extends Cliente  {

	@Autowired
	ClienteRepository clienteRepository;
	@Override
	public Cliente cadastrar(Cliente cliente, Long id) throws Exception {

		if(id != 2) {
			return cliente;
		}
		
		if(!cliente.getColaborador().getNome().isEmpty() && !cliente.getColaborador().getCpf().isEmpty() && !cliente.getColaborador().getEndereco().isEmpty()) {

			Cliente clientePampulha =	new Cliente();
			clientePampulha.setId(cliente.getId());
			clientePampulha.setEmpresa(cliente.getEmpresa());
			clientePampulha.setId(cliente.getId());
			clientePampulha.setPlanos(cliente.getEmpresa().getPlanos());
			
			Colaborador colaboradorPampulha = new Colaborador();
	
			colaboradorPampulha.setId(cliente.getColaborador().getId().longValue());
			colaboradorPampulha.setNome(cliente.getColaborador().getNome().toString());
			colaboradorPampulha.setCpf(cliente.getColaborador().getCpf().toString());
			colaboradorPampulha.setDtAdmissao(LocalDateTime.now());
			colaboradorPampulha.setEmail("");
			colaboradorPampulha.setEndereco(cliente.getColaborador().getEndereco());
			colaboradorPampulha.setPeso(0);
			colaboradorPampulha.setAltura(0);
			colaboradorPampulha.setHorasMeditadas(0);
			clientePampulha.setColaborador(colaboradorPampulha);
//			clienteRepository.save(clientePampulha);
			return clientePampulha;
	}else {
		 throw new Exception("Dados Inválidos");
	}
		
	}
}
