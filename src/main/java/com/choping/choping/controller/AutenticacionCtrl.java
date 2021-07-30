package com.choping.choping.controller;

import static org.springframework.http.ResponseEntity.ok;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.AuthenticationException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.GetMapping;
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

@RestController
@RequestMapping("/api/autenticacion")
public class AutenticacionCtrl {
	@Autowired
	AuthenticationManager authenticationManager;
	
    @Autowired
    JwtTokenProvider jwtTokenProvider;
	
	@Autowired
	UsuarioRepository users;
	
	@Autowired
	UsuarioServiceImp usuarios;
	
	@Autowired
	TipoUsuarioImpl tUSrv;
	
	@SuppressWarnings("rawtypes")
	@PostMapping("/login")
	public ResponseEntity login(@RequestBody AutenticacionBody datos) {
		try {
			UsernamePasswordAuthenticationToken authT = 
					new UsernamePasswordAuthenticationToken(
							datos.getEmail(), 
							datos.getPassword());
			org.springframework.security.core.Authentication auth = authenticationManager.authenticate(authT);
			List<?> rolesL = (List) auth.getAuthorities();
			String tipo_usuario = 
					((GrantedAuthority) rolesL.get(0)).getAuthority();
			System.out.println(tipo_usuario);
			String token = jwtTokenProvider.createToken(auth.getName(), 
					tipo_usuario);
			Map<Object, Object> modelo = new HashMap<>();
            modelo.put("token", token);   
			return ok(modelo);
		}catch (Exception e) {
			System.out.println(e);
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("Credenciales inválidas. Verifica la información");
		}
		
		
	}
	
	@SuppressWarnings("rawtypes")
    @PostMapping("/registro")
    public ResponseEntity register(@Valid @RequestBody Usuario user) {
    	System.out.println(user);
        return usuarios.crearUsuario(user);
    }
	
	 @GetMapping("/registro/tipos_usuario")
	    public ResponseEntity<Object> getTiposUsuario() {
	    	return new ResponseEntity<Object>(
	    			this.tUSrv.getTiposUsuario(), HttpStatus.OK);
	    }
}
