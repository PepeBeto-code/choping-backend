package com.choping.choping.controller;

import static org.springframework.http.ResponseEntity.ok;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.choping.choping.config.JwtTokenProvider;
import com.choping.choping.modelo.AutenticacionBody;
import com.choping.choping.modelo.Usuario;
import com.choping.choping.repository.UsuarioRepository;
import com.choping.choping.service.TipoUsuarioImpl;
import com.choping.choping.service.UsuarioServiceImp;

public class AutenticacionCtrl {
	@Autowired
	AuthenticationManager authenticationmanager;
	
    @Autowired
    JwtTokenProvider jwtTokenProvider;
	
	@Autowired
	UsuarioRepository users;
	
	@Autowired
	UsuarioServiceImp usuarios;
	
	@Autowired
	TipoUsuarioImpl tUSrv;
	
	@PostMapping("/login")
	public ResponseEntity<Map<Object,Object>> login(@RequestBody AutenticacionBody datos) {
		try {
			String email = datos.getEmail();
			Usuario usuario = this.users.findByEmail(email);
			
			
			authenticationmanager.authenticate(new UsernamePasswordAuthenticationToken(email, datos.getPassword()));
            String token = jwtTokenProvider.createToken(email, usuario.getTipo_usuario());
            
            Map<Object, Object> respuesta = new HashMap<>();            
            respuesta.put("username", usuario.getEmail());
            respuesta.put("token", token);
            return ok(respuesta);
				
		}catch(Exception e) {
			Map<Object, Object> respuesta = new HashMap<>();   
			respuesta.put("Mensaje", "Error en proceso de autenticacion");
			respuesta.put("Exception", e.getMessage());
			return new ResponseEntity<Map<Object, Object>>(respuesta, HttpStatus.I_AM_A_TEAPOT);
		}
		
		
	}
	
	@SuppressWarnings("rawtypes")
    @PostMapping("/registro/{id}")
    public ResponseEntity register(@Valid @RequestBody Usuario user, 
    		@PathVariable int id) {
    	System.out.println(user);
        return usuarios.crearUsuario(user);
    }
	
	 @GetMapping("/registro/tipos_usuario")
	    public ResponseEntity<Object> getTiposUsuario() {
	    	return new ResponseEntity<Object>(
	    			this.tUSrv.getTiposUsuario(), HttpStatus.OK);
	    }
}
