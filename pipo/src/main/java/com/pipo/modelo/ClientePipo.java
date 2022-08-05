package com.pipo.modelo;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class ClientePipo {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private  String nome;
	private String cpf;
	private LocalDateTime dtAdmissao;
	private String email;
	private String endereco;
	private double peso;
	private double altura;
	private double horasMeditadas;
	private String nomePlano;
	private String nomeEmpresa;
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public LocalDateTime getDtAdmissao() {
		return dtAdmissao;
	}
	public void setDtAdmissao(LocalDateTime dtAdmissao) {
		this.dtAdmissao = dtAdmissao;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	public double getHorasMeditadas() {
		return horasMeditadas;
	}
	public void setHorasMeditadas(double horasMeditadas) {
		this.horasMeditadas = horasMeditadas;
	}
	public String getNomePlano() {
		return nomePlano;
	}
	public void setNomePlano(String nomePlano) {
		this.nomePlano = nomePlano;
	}
	public String getNomeEmpresa() {
		return nomeEmpresa;
	}
	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}
	
	
}
