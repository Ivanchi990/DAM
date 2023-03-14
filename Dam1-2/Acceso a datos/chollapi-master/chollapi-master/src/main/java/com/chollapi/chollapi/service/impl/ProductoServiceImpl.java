package com.chollapi.chollapi.service.impl;

import com.chollapi.chollapi.dto.ProductoDto;
import com.chollapi.chollapi.modelo.Categoria;
import com.chollapi.chollapi.modelo.Oferta;
import com.chollapi.chollapi.modelo.Producto;
import com.chollapi.chollapi.repositorio.CategoriaRepository;
import com.chollapi.chollapi.repositorio.ProductoRepository;
import com.chollapi.chollapi.service.ProductoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class ProductoServiceImpl implements ProductoService
{

    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public Producto obtenerProductoID(Long id)
    {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    public Producto crearProducto(ProductoDto productoDto)
    {
        Categoria categoria = categoriaRepository.findById(productoDto.getIdCategoria()).get();
        Producto producto = new Producto(productoDto.getNombre(), productoDto.getCaracteristicas(), productoDto.getIdFabricante());

        producto.setCategoria(categoria);
        categoria.addProducto(producto);

        return productoRepository.save(producto);
    }

    @Override
    public Producto modificarProducto(ProductoDto productoDto)
    {
        Producto producto = new Producto(productoDto.getNombre(), productoDto.getCaracteristicas(), productoDto.getIdFabricante());

        producto.setCategoria(categoriaRepository.findById(productoDto.getIdCategoria()).get());

        return productoRepository.save(producto);
    }

    @Override
    public Boolean eliminarProducto(Long id)
    {
        productoRepository.deleteById(id);

        return !productoRepository.existsById(id);
    }

    @Override
    public List<Producto> buscarProducto(String texto)
    {
        return productoRepository.buscarProducto(texto);
    }

    @Override
    public List<Oferta> mejores10(Long idProducto)
    {
        List<Oferta> ofertas = productoRepository.mejores10(idProducto);

        return ofertas;
    }

    @Override
    public List<ProductoDto> listar5Pag(Pageable pageable)
    {
        List<ProductoDto> productoDtos = new ArrayList<>();

        for(Producto p: productoRepository.findAll(pageable))
        {
            productoDtos.add(new ProductoDto(p.getIdProducto(), p.getNombre(), p.getCaracteristicas(), p.getIdFabricante()));
        }

        return productoDtos;
    }
}
