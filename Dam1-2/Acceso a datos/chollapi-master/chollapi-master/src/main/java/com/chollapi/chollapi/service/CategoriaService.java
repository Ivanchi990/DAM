package com.chollapi.chollapi.service;

import com.chollapi.chollapi.modelo.Categoria;
import com.chollapi.chollapi.modelo.Producto;

import java.util.List;

public interface CategoriaService
{
    Categoria obtenerCategoriaID(Long id);

    Categoria crearCategoria(Categoria categoria);

    Categoria modificarCategoria(Categoria categoria);

    Boolean eliminarCategoria(Long id);

    List<Producto> ultimos5(Long idCategoria);
}
