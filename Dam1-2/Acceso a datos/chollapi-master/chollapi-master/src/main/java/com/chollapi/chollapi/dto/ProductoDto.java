package com.chollapi.chollapi.dto;

import com.google.gson.annotations.Expose;
import lombok.Data;

import java.io.Serializable;

@Data
public class ProductoDto implements Serializable
{
    @Expose
    public Long idProducto;
    @Expose
    public String nombre;
    @Expose
    public String caracteristicas;
    @Expose
    public Long idFabricante;
    @Expose
    public Long idCategoria;

    public ProductoDto(Long idProducto, String nombre, String caracteristicas, Long idFabricante)
    {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.caracteristicas = caracteristicas;
        this.idFabricante = idFabricante;
    }
}
