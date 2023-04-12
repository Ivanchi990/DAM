package add.bedam.entidades;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Compra implements Serializable
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCompra;
	private Date fecha_compra;
	private Float precio_total;
	private String usuario;

	@ManyToMany
	@JoinTable(
			name = "detalle_compra",
			joinColumns = {@JoinColumn(name = "idCompra")},
			inverseJoinColumns = {@JoinColumn(name = "idPrenda")}
	)
	private Set<Prenda> prendas = new HashSet<>();

	public Compra()
	{
		super();
	}

	public Compra(Long idCompra, Date fechaCompra, Float precioTotal, String usuario, Set<Prenda> prendas) {
		super();
		this.idCompra = idCompra;
		this.fecha_compra = fechaCompra;
		this.precio_total = precioTotal;
		this.usuario = usuario;
		this.prendas = prendas;
	}



	public Long getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(Long idCompra) {
		this.idCompra = idCompra;
	}

	public Date getFecha_compra() {
		return fecha_compra;
	}

	public void setFecha_compra(Date fechaCompra) {
		this.fecha_compra = fechaCompra;
	}

	public Float getPrecio_total() {
		return precio_total;
	}

	public void setPrecio_total(Float precio_total) {
		this.precio_total = precio_total;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Set<Prenda> getPrendas() {
		return prendas;
	}

	public void setPrendas(Set<Prenda> prendas) {
		this.prendas = prendas;
	}

	// getters y setters
}