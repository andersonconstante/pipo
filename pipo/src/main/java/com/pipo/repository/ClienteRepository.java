package com.pipo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pipo.modelo.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
