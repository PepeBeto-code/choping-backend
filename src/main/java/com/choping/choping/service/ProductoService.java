package com.choping.choping.service;

import java.util.List;
import com.choping.choping.modelo.Producto;
import com.choping.choping.modelo.ProductoDto;


public interface ProductoService {
	public abstract List<ProductoDto> getProductos();
	public abstract List<ProductoDto> getProductosPorUsuario(int idUsuario);
	public abstract void crearproducto(Producto producto);


}
