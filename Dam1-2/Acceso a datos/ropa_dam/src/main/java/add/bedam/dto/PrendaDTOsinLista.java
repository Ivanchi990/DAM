package add.bedam.dto;

import java.io.Serializable;
import java.util.Objects;

public class PrendaDTOsinLista implements Serializable
{
	private Long idPrenda;
	private String nombre;
	private String descripcion;
	private Float precio;
	private Long idCategoria;

	public PrendaDTOsinLista() {
		super();
	}

	public PrendaDTOsinLista(Long idPrenda, String nombre, String descripcion, Float precio, Long idCategoria) {
		super();
		this.idPrenda = idPrenda;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.idCategoria = idCategoria;
	}

	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public Long getIdPrenda() {
		return idPrenda;
	}

	public void setIdPrenda(Long idPrenda) {
		this.idPrenda = idPrenda;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descripcion, idPrenda, nombre, precio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PrendaDTOsinLista other = (PrendaDTOsinLista) obj;
		return Objects.equals(descripcion, other.descripcion) && Objects.equals(idPrenda, other.idPrenda)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(precio, other.precio);
	}

}
