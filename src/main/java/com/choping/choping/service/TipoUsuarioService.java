package com.choping.choping.service;

import java.util.List;

import com.choping.choping.modelo.TipoUsuario;


public interface TipoUsuarioService {
	public abstract TipoUsuario getTipoUsuario(int id);
	public abstract List<TipoUsuario> getTiposUsuario();
}
