package add.bedam.servicios;

import java.util.ArrayList;
import java.util.List;

import add.bedam.repositorios.PrendaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import add.bedam.dto.PrendaDTOsinLista;
import add.bedam.entidades.Prenda;

@Service
public class PrendaServiceImpl implements PrendaService
{
	@Autowired
	private PrendaRepository prendaRepository;
	@Autowired
	ModelMapper modelMapper = new ModelMapper();

	public Prenda crearPrenda(PrendaDTOsinLista prendaDto)
	{
		return prendaRepository.save(modelMapper.map(prendaDto, Prenda.class));
	}

	@Override
	public Prenda obtenerPrenda(Long idPrenda)
	{
		return prendaRepository.findById(idPrenda).get();
	}

	@Override
	public List<PrendaDTOsinLista> obtenerPrendaPaginadas(int page, int size)
	{
		Page<Prenda> pren = prendaRepository.findAll(PageRequest.of(page, size));
		List<PrendaDTOsinLista> prendas = new ArrayList<>();

		for(Prenda p: pren)
		{
			prendas.add(modelMapper.map(p, PrendaDTOsinLista.class));
		}

		return prendas;
	}

	@Override
	public Prenda editarPrenda(Long idPrenda, PrendaDTOsinLista prendaDto)
	{
		Prenda prenda = prendaRepository.findById(idPrenda).get();
		Prenda nueva = modelMapper.map(prendaDto, Prenda.class);

		nueva.setIdPrenda(prenda.getIdPrenda());
		nueva.setCompras(prenda.getCompras());

		return prendaRepository.save(nueva);
	}
	@Override
	public List<PrendaDTOsinLista> buscarPrendas(String cadena, int page, int size)
	{
		Page<Prenda> pren = prendaRepository.findByNombreContaining(cadena, PageRequest.of(page, size));
		List<PrendaDTOsinLista> prendas = new ArrayList<>();

		for(Prenda p: pren)
		{
			prendas.add(modelMapper.map(p, PrendaDTOsinLista.class));
		}

		return prendas;
	}
}
