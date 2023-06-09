package com.chollapi.chollapi.modelo;

import com.google.gson.annotations.Expose;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "Categoria")
public class Categoria implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="idCategoria")
    @Expose
    private Long idCategoria;

    @Column(name = "nombre")
    @Expose
    private String nombre;

    @Column(name = "descripcion")
    @Expose
    private String descripcion;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.MERGE)
    private List<Producto> productos = new ArrayList<>();

    public void addProducto(Producto p){
        productos.add(p);
        p.setCategoria(this);
    }

    public void removeProducto(Producto p)
    {
        productos.remove(p);
        p.setCategoria(null);
    }
}
