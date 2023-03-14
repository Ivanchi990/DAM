package com.chollapi.chollapi.service;

import com.chollapi.chollapi.dto.ProductoDto;
import com.chollapi.chollapi.modelo.Oferta;
import com.chollapi.chollapi.modelo.Producto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductoService
{
    Producto obtenerProductoID(Long id);

    Producto crearProducto(ProductoDto productoDto);

    Producto modificarProducto(ProductoDto productoDto);

    Boolean eliminarProducto(Long id);

    List<Producto> buscarProducto(String texto);

    List<ProductoDto> listar5Pag(Pageable pageable);

    List<Oferta> mejores10(Long id);
}
