package com.choping.choping.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.choping.choping.modelo.Producto;
import com.choping.choping.modelo.ProductoDto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{

	@Query("SELECT new com.choping.choping.modelo.ProductoDto(a.id, a.foto," +
			"a.precio, a.descripcion)"  +
			"FROM Producto a")
	List<ProductoDto> findAllDto();
	
	@Query("SELECT new com.choping.choping.modelo.ProductoDto(a.id, a.foto, " +
			"a.precio, a.descripcion)" + 
			"FROM Producto a WHERE a.usuario.id=?1")
	List<ProductoDto> findAllDtoUsuario(int idUsuario);

	
}
