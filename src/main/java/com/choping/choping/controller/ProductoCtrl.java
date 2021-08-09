package com.choping.choping.controller;

import java.util.HashMap;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.choping.choping.modelo.Producto;
import com.choping.choping.service.ProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoCtrl {
	@Autowired
	private ProductoService pSrv;
	
	@GetMapping("/porUsuario/{idUsuario}")
	public ResponseEntity<Object> getProductosPorUsuario(@PathVariable int idUsuario){
		return new ResponseEntity<Object>(this.pSrv.getProductosPorUsuario(idUsuario), 
				HttpStatus.OK);
	}
	
	@GetMapping()
	public ResponseEntity<Object> getProductos() {
		return new ResponseEntity<Object>(this.pSrv.getProductos(), 
				HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<Object> createExamen(@Valid @RequestBody 
			Producto producto) {
		System.out.println(producto);

		HashMap<String, String> response = new HashMap<String, String>();
		this.pSrv.crearproducto(producto);
		response.put("status", "success");
		response.put("message", "Producto creado correctamente");
		return new ResponseEntity<Object>(response, HttpStatus.CREATED);
	}

}
