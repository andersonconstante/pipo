package com.pipo.custom.planos;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;

import com.pipo.modelo.Cliente;
import com.pipo.modelo.Colaborador;
import com.pipo.repository.ClienteRepository;
import com.pipo.utils.EmailUtils;
import com.pipo.utils.PlanosEnum;

public class DentalSorriso extends Cliente {

	@Autowired
	ClienteRepository clienteRepository;
	
	@Override
	public Cliente cadastrar(Cliente cliente, Long id) throws Exception {

		if(id != 3) {
			return cliente;
		}
	
		boolean isAlturaOk = cliente.getColaborador().getAltura() > 0 && cliente.getColaborador().getAltura() < 2.5 ? true : false;
		boolean isPesoOk = cliente.getColaborador().getPeso() > 0 && cliente.getColaborador().getPeso() < 250 ? true : false;
		
		if(!cliente.getColaborador().getNome().isEmpty() && !cliente.getColaborador().getCpf().isEmpty() && isAlturaOk && isPesoOk) {
			Cliente clienteDentalSorriso =	new Cliente();
			clienteDentalSorriso.setId(cliente.getId());
			clienteDentalSorriso.setEmpresa(cliente.getEmpresa());
			clienteDentalSorriso.setId(cliente.getId());
			clienteDentalSorriso.setPlanos(cliente.getEmpresa().getPlanos());
			
			Colaborador colaboradorDentalSorriso = new Colaborador();
	
			colaboradorDentalSorriso.setId(cliente.getColaborador().getId().longValue());
			colaboradorDentalSorriso.setNome(cliente.getColaborador().getNome().toString());
			colaboradorDentalSorriso.setCpf(cliente.getColaborador().getCpf().toString());
			colaboradorDentalSorriso.setDtAdmissao(null);
			colaboradorDentalSorriso.setEmail("");
			colaboradorDentalSorriso.setEndereco("");
			colaboradorDentalSorriso.setPeso(cliente.getColaborador().getPeso());
			colaboradorDentalSorriso.setAltura(cliente.getColaborador().getAltura());
			colaboradorDentalSorriso.setHorasMeditadas(0);
			clienteDentalSorriso.setColaborador(colaboradorDentalSorriso);
//			clienteRepository.save(clienteDentalSorriso);
			return clienteDentalSorriso;
		
		}else {
			 throw new Exception("Dados Inválidos");
		}

		
	}
}
