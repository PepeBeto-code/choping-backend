package com.choping.choping.service;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import com.choping.choping.modelo.Usuario;
import com.choping.choping.modelo.UsuarioDO;
import com.choping.choping.modelo.UsuarioDto;

public interface UsuarioService {
	public abstract UserDetails loadUserByUsername(String email);
	public abstract ResponseEntity<Object> crearUsuario(Usuario usuario);
	public abstract UsuarioDto obtenerPorEmail(String email);
	public abstract UsuarioDto obtenerPorNombre(String nombre);
	public abstract UsuarioDO getUsuario(int id);


}
