package add.bedam.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CompraDto implements Serializable
{
	private Long idCompra;
	private Date fechaCompra;
	private Float precioTotal;
	private String usuario;

	private List<Long> prendas = new ArrayList<Long>();

	public CompraDto() {
		super();
	}

	public CompraDto(Long idCompra, Date fechaCompra, Float precioTotal, String usuario,
			List<Long> prendas)
	{
		super();
		this.idCompra = idCompra;
		this.fechaCompra = fechaCompra;
		this.precioTotal = precioTotal;
		this.usuario = usuario;
		this.prendas = prendas;
	}

	public Long getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(Long idCompra) {
		this.idCompra = idCompra;
	}

	public Date getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public Float getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(Float precioTotal) {
		this.precioTotal = precioTotal;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public List<Long> getPrendas() {
		return prendas;
	}

	public void setPrendas(List<Long> prendas) {
		this.prendas = prendas;
	}
}
