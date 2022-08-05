package com.pipo.modelo;

import java.util.List;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Cliente {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	private Colaborador colaborador;
	@OneToOne
	private Empresa empresa;

	@OneToMany(fetch = FetchType.LAZY)
	
	private List<Plano> planos;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Colaborador getColaborador() {
		return colaborador;
	}
	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	
	public List<Plano> getPlanos() {
		return planos;
	}
	public void setPlanos(List<Plano> planos) {
		this.planos = planos;
	}
	public Cliente cadastrar(Cliente cliente, Long id) throws Exception {
		return cliente;
		
	}

	
	
}
