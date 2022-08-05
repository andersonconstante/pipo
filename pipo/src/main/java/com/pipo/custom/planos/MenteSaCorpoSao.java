package com.pipo.custom.planos;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;

import com.pipo.modelo.Cliente;
import com.pipo.modelo.Colaborador;
import com.pipo.repository.ClienteRepository;
import com.pipo.utils.PlanosEnum;

public class MenteSaCorpoSao extends Cliente {

	@Autowired
	ClienteRepository clienteRepository;
	@Override
	public Cliente cadastrar(Cliente cliente, Long id) throws Exception {

		if(id != 4) {
			return cliente;
		}

		boolean isHorasMeditadasOk = cliente.getColaborador().getHorasMeditadas() >= 0 && cliente.getColaborador().getHorasMeditadas() < 168 ? true : false;		
		
		if(!cliente.getColaborador().getCpf().isEmpty() && isHorasMeditadasOk) {
			Cliente clienteMenteSaCorpoSao =	new Cliente();
			clienteMenteSaCorpoSao.setId(cliente.getId());
			clienteMenteSaCorpoSao.setEmpresa(cliente.getEmpresa());
			clienteMenteSaCorpoSao.setId(cliente.getId());
			clienteMenteSaCorpoSao.setPlanos(cliente.getEmpresa().getPlanos());
			
			Colaborador colaboradorMenteSaCorpoSao = new Colaborador();

			colaboradorMenteSaCorpoSao.setId(cliente.getColaborador().getId().longValue());
			colaboradorMenteSaCorpoSao.setNome("");
			colaboradorMenteSaCorpoSao.setCpf(cliente.getColaborador().getCpf().toString());
			colaboradorMenteSaCorpoSao.setDtAdmissao(null);
			colaboradorMenteSaCorpoSao.setEmail("");
			colaboradorMenteSaCorpoSao.setEndereco("");
			colaboradorMenteSaCorpoSao.setPeso(0);
			colaboradorMenteSaCorpoSao.setAltura(0);
			colaboradorMenteSaCorpoSao.setHorasMeditadas(cliente.getColaborador().getHorasMeditadas());
			clienteMenteSaCorpoSao.setColaborador(colaboradorMenteSaCorpoSao);
//			clienteRepository.save(clienteMenteSaCorpoSao);
			return clienteMenteSaCorpoSao;

		}
		else {
			 throw new Exception("Dados Inválidos");
		}
		
	}
}
