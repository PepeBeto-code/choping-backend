package com.choping.choping.modelo;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ProductoDto {
    
	private int id;
	
	private String foto;
	
	private double precio;
	
	private String descripcion;
	
	public ProductoDto(int id, String foto, double precio, String descripcion) {
		super();
		this.id = id;
		this.foto = foto;
		this.precio = precio;
		this.descripcion = descripcion;
	}
}
