package com.choping.choping.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="tipo_usuario")
public class TipoUsuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column(name="nombre")
	private String nombre_tipo_usuario;
	
	@Column(name="descripcion")
	private String descripcion;
}
