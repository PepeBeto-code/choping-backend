package com.choping.choping.modelo;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)

@Data
public class UsuarioDO {
    
	private int id;
	
	private String nombre;
	
	private String password;
	
	private String email;
	
	private String telefono;
	
	private String tipo;
	
	public UsuarioDO(int id, String nombre, String password, String email,String telefono, String tipo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.password = password;
		this.email = email;
		this.telefono = telefono;
		this.tipo=tipo;

	}

}
