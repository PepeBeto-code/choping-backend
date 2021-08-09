package com.choping.choping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.choping.choping.modelo.UsuarioDto;
import com.choping.choping.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	@Autowired
	private UsuarioService uSrv;
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getUsuario(@PathVariable int id){
		return new ResponseEntity<Object>(this.uSrv.
				getUsuario(id), HttpStatus.OK);
	}
	
	@GetMapping("/porEmail/{email}")
	public ResponseEntity<Object> obtenerPorEmail(@PathVariable String email) {
		System.out.println(email);
		UsuarioDto usuario=this.uSrv.obtenerPorEmail(email);
		if(usuario!=null) {
			System.out.println(usuario);
			return new ResponseEntity<Object>(
					this.uSrv.obtenerPorEmail(email), 
					HttpStatus.OK);
		}else {
			return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("No se a encontrado el usuario");
		}
	}
	
	@GetMapping("/porNombre/{nombre}")
	public ResponseEntity<Object> obtenerPorNombre(@PathVariable String nombre) {
			UsuarioDto usuario=this.uSrv.obtenerPorNombre(nombre);
			if(usuario!=null) {
				System.out.println(usuario);
				return new ResponseEntity<Object>(
						this.uSrv.obtenerPorNombre(nombre), 
						HttpStatus.OK);
			}else {
				return ResponseEntity
	                    .status(HttpStatus.BAD_REQUEST)
	                    .body("No se a encontrado el usuario");
			}
		
	}
}
