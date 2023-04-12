package add.bedam.servicios;

import java.util.List;

import add.bedam.dto.PrendaDTOsinLista;
import add.bedam.entidades.Prenda;

public interface PrendaService
{
	public Prenda crearPrenda(PrendaDTOsinLista prendaDto);
	public Prenda obtenerPrenda(Long idPrenda);
	public Prenda editarPrenda(Long idPrenda, PrendaDTOsinLista prendaDto);
	public List<PrendaDTOsinLista> obtenerPrendaPaginadas(int index, int count);
	public List<PrendaDTOsinLista> buscarPrendas(String cadena, int index, int count);
}
