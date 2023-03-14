package com.chollapi.chollapi.service.impl;

import com.chollapi.chollapi.modelo.Categoria;
import com.chollapi.chollapi.modelo.Producto;
import com.chollapi.chollapi.repositorio.CategoriaRepository;
import com.chollapi.chollapi.repositorio.ProductoRepository;
import com.chollapi.chollapi.service.CategoriaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service
public class CategoriaServiceImpl implements CategoriaService
{
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private ProductoRepository productoRepository;
    @Override
    public Categoria obtenerCategoriaID(Long id)
    {
        return categoriaRepository.findById(id).orElse(null);
    }

    @Override
    public Categoria crearCategoria(Categoria categoria)
    {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria modificarCategoria(Categoria categoria)
    {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Boolean eliminarCategoria(Long id)
    {
        Categoria categoria = categoriaRepository.findById(id).get();

        for(Producto p : categoria.getProductos())
        {
            if(p.getCategoria().getIdCategoria().equals(id))
            {
                p.setCategoria(categoriaRepository.getOne(1L));
                productoRepository.save(p);
            }
        }

        categoriaRepository.delete(categoria);

        return !categoriaRepository.existsById(id);
    }

    @Override
    public List<Producto> ultimos5(Long idCategoria)
    {
        return categoriaRepository.ultimos5(idCategoria);
    }
}
