package modelos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name="Oferta")
@NamedQuery(name="Oferta.findAll", query="SELECT o FROM Oferta o")
public class Oferta implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idOferta")
    private Long idOferta;

    @Column(name="url")
    private String url;

    @Temporal(TemporalType.DATE)
    @Column(name="fechaPubli")
    private Date fechaPublicacion;

    @Column(name="precio")
    private Float precio;

    @Column(name="disponible")
    private Boolean disponible;

    //bi-directional many-to-many association to Playlist
    @ManyToMany(mappedBy="ofertas", cascade={CascadeType.PERSIST, CascadeType.MERGE})
    private List<Producto> productos = new ArrayList<Producto>();

    public Oferta() {

    }

    public Long getIdOferta() {
        return idOferta;
    }

    public void setIdOferta(Long idOferta) {
        this.idOferta = idOferta;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public void anadirProducto(Producto p) {
        productos.add( p );
        p.getOfertas().add( this );
    }

    public void removeProducto(Producto p) {
        productos.remove( p );
        p.getOfertas().remove( this );
    }

    @Override
    public String toString() {
        return "Oferta [idOferta=" + idOferta + ", url=" + url + ", fechaPublicacion=" + fechaPublicacion + ", precio="
                + precio + ", disponible=" + disponible +"]" + "\n";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Oferta)) return false;
        Oferta oferta = (Oferta) o;
        return Objects.equals(getIdOferta(), oferta.getIdOferta()) && Objects.equals(getUrl(), oferta.getUrl()) && Objects.equals(getFechaPublicacion(), oferta.getFechaPublicacion()) && Objects.equals(getPrecio(), oferta.getPrecio()) && Objects.equals(disponible, oferta.disponible) && Objects.equals(getProductos(), oferta.getProductos());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdOferta(), getUrl(), getFechaPublicacion(), getPrecio(), disponible, getProductos());
    }
}
