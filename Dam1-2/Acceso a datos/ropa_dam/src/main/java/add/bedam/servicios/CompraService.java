package add.bedam.servicios;

import add.bedam.dto.CompraDto;
import add.bedam.entidades.Compra;

public interface CompraService
{
	public Compra crearCompra(CompraDto dto);
	public Compra devolverPrenda(Long idCompra, Long idPrenda);
	public CompraDto convertirACompraDTO(Compra compra);
}
