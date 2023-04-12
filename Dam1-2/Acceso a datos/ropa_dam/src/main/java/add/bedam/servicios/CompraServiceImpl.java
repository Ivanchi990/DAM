package add.bedam.servicios;

import java.util.*;
import java.util.stream.Collectors;

import add.bedam.repositorios.CompraRepository;
import add.bedam.repositorios.PrendaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import add.bedam.dto.CompraDto;
import add.bedam.entidades.Compra;
import add.bedam.entidades.Prenda;

@Service
public class CompraServiceImpl implements CompraService
{
	@Autowired
	CompraRepository compraRepository;
	@Autowired
	PrendaRepository prendaRepository;
	@Autowired
	ModelMapper modelMapper = new ModelMapper();

	@Override
	public Compra crearCompra(CompraDto compraDto)
	{
		return compraRepository.save(convertirACompra(compraDto));
	}

	private Compra convertirACompra(CompraDto compraDto)
	{
		Compra compra = new Compra();

		compra.setFecha_compra(compraDto.getFechaCompra());
		compra.setPrecio_total(compraDto.getPrecioTotal());
		compra.setUsuario(compraDto.getUsuario());

		Set<Prenda> prendas = new HashSet<>();

		for(Long id: compraDto.getPrendas())
		{
			prendas.add(prendaRepository.findById(id).get());
		}

		compra.setPrendas(prendas);

		return compra;
	}

	@Override
	public Compra devolverPrenda(Long idCompra, Long idPrenda) {

		return null;
	}

	public CompraDto convertirACompraDTO(Compra compra)
	{
		CompraDto compraDTO = new CompraDto();

		compraDTO.setFechaCompra(compra.getFecha_compra());
		compraDTO.setIdCompra(compra.getIdCompra());
		compraDTO.setPrecioTotal(compra.getPrecio_total());
		compraDTO.setUsuario(compra.getUsuario());

		List<Long> idPrendas = compra.getPrendas().stream().map(Prenda::getIdPrenda).collect(Collectors.toList());
		Collections.sort(idPrendas);

		compraDTO.setPrendas(idPrendas);

		return compraDTO;
	}
}
