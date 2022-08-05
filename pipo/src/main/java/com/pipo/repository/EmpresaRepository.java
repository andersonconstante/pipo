package com.pipo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pipo.modelo.Empresa;


public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

}
