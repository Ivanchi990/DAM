package add.bedam.entidades;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Categoria implements Serializable
{
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long idCategoria;
	private String sexo;
	private String nombre;

	@OneToMany(mappedBy = "categoria", cascade = CascadeType.MERGE)
	private Set<Prenda> prendas = new HashSet<>();

	public Categoria() {
		super();
	}

	public Categoria(Long idCategoria, String sexo, String nombre, Set<Prenda> prendas)
	{
		this.idCategoria = idCategoria;
		this.sexo = sexo;
		this.nombre = nombre;
		this.prendas = prendas;
	}

	// getters y setters
	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Prenda> getPrendas() {
		return prendas;
	}

	public void setPrendas(Set<Prenda> prendas) {
		this.prendas = prendas;
	}
}
