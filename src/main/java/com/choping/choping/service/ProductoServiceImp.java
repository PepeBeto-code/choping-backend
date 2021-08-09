package com.choping.choping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choping.choping.modelo.Producto;
import com.choping.choping.modelo.ProductoDto;
import com.choping.choping.repository.ProductoRepository;

@Service
public class ProductoServiceImp implements ProductoService{
	
	@Autowired
	private ProductoRepository pRep;
	
	@Override
	public List<ProductoDto> getProductos() {
		return pRep.findAllDto();
	}
	
	@Override
	public  List<ProductoDto> getProductosPorUsuario(int idUsuario){
		return pRep.findAllDtoUsuario(idUsuario);	
	}
	
	@Override
	public  void crearproducto(Producto producto) {
		this.pRep.save(producto);
	}



}
