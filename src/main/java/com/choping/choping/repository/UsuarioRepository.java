package com.choping.choping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.choping.choping.modelo.Usuario;
import com.choping.choping.modelo.UsuarioDO;
import com.choping.choping.modelo.UsuarioDto;



@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	@Query("SELECT new com.choping.choping.modelo.UsuarioDO(a.id, a.nombre, " +
			"a.password, a.email, a.telefono,a.tipo_usuario.nombre)" + 
			"FROM Usuario a WHERE a.id=?1")
	UsuarioDO obtenerDo(int id);
	
	Usuario findById(int id);
	Usuario findByEmail(String email);
	@Query("SELECT new com.choping.choping.modelo.UsuarioDto(a.id, a.nombre, " +
			"a.password, a.email, a.telefono)" + 
			"FROM Usuario a WHERE a.email=?1")
	UsuarioDto findByEmailDto(String email);
	@Query("SELECT new com.choping.choping.modelo.UsuarioDto(a.id, a.nombre, " +
			"a.password, a.email, a.telefono)" + 
			"FROM Usuario a WHERE a.nombre=?1")
	UsuarioDto findByNombreDto(String nombre);

}
