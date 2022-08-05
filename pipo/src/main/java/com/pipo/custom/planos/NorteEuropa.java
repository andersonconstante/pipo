package com.pipo.custom.planos;



import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;

import com.pipo.modelo.Cliente;
import com.pipo.modelo.Colaborador;
import com.pipo.repository.ClienteRepository;
import com.pipo.utils.EmailUtils;



public class NorteEuropa extends Cliente  {

	@Autowired
	ClienteRepository clienteRepository;
	@Override
	public Cliente cadastrar(Cliente cliente, Long id) throws Exception {


		if(id != 1) {
			return cliente;
		}
		
		boolean emailValido = EmailUtils.isEmailValido(cliente.getColaborador().getEmail());
	
		
		if(!cliente.getColaborador().getNome().isEmpty() && !cliente.getColaborador().getCpf().isEmpty() && emailValido == true) {
			Cliente clienteEuropa =	new Cliente();
			clienteEuropa.setId(cliente.getId());
			clienteEuropa.setEmpresa(cliente.getEmpresa());
			clienteEuropa.setId(cliente.getId());
			
			clienteEuropa.setPlanos(cliente.getEmpresa().getPlanos());
			
			Colaborador colaboradorEuropa = new Colaborador();

			colaboradorEuropa.setId(cliente.getColaborador().getId().longValue());
			colaboradorEuropa.setNome(cliente.getColaborador().getNome().toString());
			colaboradorEuropa.setCpf(cliente.getColaborador().getCpf().toString());
			colaboradorEuropa.setDtAdmissao(LocalDateTime.now());
			colaboradorEuropa.setEmail(cliente.getColaborador().getEmail().toString());
			colaboradorEuropa.setEndereco("");
			colaboradorEuropa.setPeso(0);
			colaboradorEuropa.setAltura(0);
			colaboradorEuropa.setHorasMeditadas(0);
			clienteEuropa.setColaborador(colaboradorEuropa);
//			clienteRepository.save(clienteEuropa);
			return clienteEuropa;
		}else {
			 throw new Exception("Dados Inválidos");
		}

		
	}



}
