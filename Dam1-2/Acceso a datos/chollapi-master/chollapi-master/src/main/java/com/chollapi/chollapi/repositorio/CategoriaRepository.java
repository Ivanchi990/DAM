package com.chollapi.chollapi.repositorio;

import com.chollapi.chollapi.modelo.Categoria;
import com.chollapi.chollapi.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>
{
    @Query(value = "SELECT p FROM Producto p JOIN p.categoria c WHERE c.idCategoria = :idCategoria")
    List<Producto> ultimos5(@Param("idCategoria") Long idCategoria);
}
