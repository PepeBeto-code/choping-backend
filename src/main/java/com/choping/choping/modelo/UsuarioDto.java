package com.choping.choping.modelo;


import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)

@Data
public class UsuarioDto {
	
	private int id;
	
	private String nombre;
	
	private String password;
	
	private String email;
	
	private String telefono;
	
	public UsuarioDto(int id, String nombre, String password, String email,String telefono) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.password = password;
		this.email = email;
		this.telefono = telefono;

	}
}
