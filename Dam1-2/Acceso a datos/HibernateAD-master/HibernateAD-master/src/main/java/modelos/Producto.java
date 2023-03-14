package modelos;

import com.sun.istack.Nullable;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "Producto")
@NamedQuery(name="producto.findAll", query="SELECT p FROM Producto p")
public class Producto implements Serializable
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idProducto")
    private Long idProducto;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "idFabricante") @Nullable
    private Long idFabricante;

    @ManyToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name="producto_oferta"
            , joinColumns={
            @JoinColumn(name="idProducto")
    }
            , inverseJoinColumns={
            @JoinColumn(name="idOferta")
    }
    )
    private List<Oferta> ofertas = new ArrayList<>();

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getIdFabricante() {
        return idFabricante;
    }

    public void setIdFabricante(Long idFabricante) {
        this.idFabricante = idFabricante;
    }

    public List<Oferta> getOfertas() {
        return ofertas;
    }

    public void setOfertas(List<Oferta> ofertas) {
        this.ofertas = ofertas;
    }

    public void anadirOferta(Oferta o)
    {
        ofertas.add(o);
    }

    public void eliminarOferta(Oferta o)
    {
        ofertas.remove(o);
    }
}
