package com.choping.choping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.choping.choping.modelo.Usuario;



@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	Usuario findById(int id);
	Usuario findByEmail(String email);

}
