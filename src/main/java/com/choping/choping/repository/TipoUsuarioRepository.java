package com.choping.choping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.choping.choping.modelo.TipoUsuario;

@Repository
public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Integer>{
	TipoUsuario findByid(int id);
	TipoUsuario findByNombre(String nombre);
}
