package com.choping.choping.service;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import com.choping.choping.modelo.Usuario;

public interface UsuarioService {
	public abstract UserDetails loadUserByUsername(String email);
	public abstract ResponseEntity<Object> crearUsuario(Usuario usuario);
}
