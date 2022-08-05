package com.pipo.controller;

import java.rmi.ServerException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pipo.custom.planos.FormPlano;
import com.pipo.modelo.Cliente;
import com.pipo.modelo.ClientePipo;
import com.pipo.modelo.Colaborador;
import com.pipo.modelo.Empresa;
import com.pipo.modelo.Plano;
import com.pipo.repository.ClientePipoRepository;
import com.pipo.repository.ClienteRepository;
import com.pipo.repository.ColaboradorRepository;
import com.pipo.repository.EmpresaRepository;
import com.pipo.repository.PlanoRepository;

@RestController
@RequestMapping("cliente")
public class ClienteController {

	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	EmpresaRepository empresaRepository;
	@Autowired
	ColaboradorRepository colaboradorRepository;
	@Autowired
	PlanoRepository planoRepository;
	
	@Autowired
	ClientePipoRepository clientePipoRepository;

	@GetMapping(value = "")
	public ResponseEntity<List<Cliente>> listarColaboradores() {

		List<Cliente> clientes = clienteRepository.findAll();

		if (clientes.isEmpty()) {
			ResponseEntity.notFound();
		}
		return ResponseEntity.ok(clientes.stream().collect(Collectors.toList()));

	}

	@PostMapping(path = "/cadastrar")
	public ResponseEntity<List<ClientePipo>> cadastrar(@RequestBody FormPlano novoCliente) throws ServerException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		
		
		Colaborador colaborador = colaboradorRepository.findById(novoCliente.getIdColaborador()).get();
		Empresa empresa = empresaRepository.findById(novoCliente.getIdEmpresa()).get();
				
		Cliente cliente = new Cliente();
		
		List<ClientePipo> clientes = new ArrayList<>();
			
		cliente.setColaborador(colaborador);
		cliente.setEmpresa(empresa);
		cliente.setPlanos(cliente.getPlanos());
		
		int index = 0;
		List<Plano> planos = empresa.getPlanos();
			for(Plano p : planos) {
				
				
				String nomedaClasse = p.getNome().toString();
				Class<?> clazz = Class.forName("com.pipo.custom.planos."+nomedaClasse);

				Cliente t  = (Cliente) clazz.newInstance();
				try {
					Cliente temp = new Cliente();
					temp = t.cadastrar(cliente, p.getId());
					ClientePipo clientePipo = new ClientePipo();
					clientePipo.setNome(temp.getColaborador().getNome());
					clientePipo.setCpf(temp.getColaborador().getCpf());
					clientePipo.setDtAdmissao(temp.getColaborador().getDtAdmissao());
					clientePipo.setEmail(temp.getColaborador().getEmail());
					clientePipo.setEndereco(temp.getColaborador().getEndereco());
					clientePipo.setPeso(temp.getColaborador().getPeso());
					clientePipo.setAltura(temp.getColaborador().getAltura());
					clientePipo.setHorasMeditadas(temp.getColaborador().getHorasMeditadas());
					clientePipo.setNomePlano(temp.getEmpresa().getPlanos().get(index).getNome());
					clientePipo.setNomeEmpresa(temp.getEmpresa().getNome());	
					clientePipoRepository.save(clientePipo);
					clientes.add(clientePipo);
					index++;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

	 
	    return new ResponseEntity<>(clientes, HttpStatus.CREATED);
	}
}
