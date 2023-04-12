package add.bedam.controladores;

import java.util.List;

import add.bedam.entidades.Prenda;
import add.bedam.repositorios.PrendaRepository;
import add.bedam.servicios.PrendaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import add.bedam.dto.PrendaDTOsinLista;

@RestController
@RequestMapping("/prenda")
public class PrendaControlador
{
	@Autowired
	ModelMapper modelMapper = new ModelMapper();
	@Autowired
	PrendaService prendaService;
	@Autowired
	private PrendaRepository prendaRepository;

	@PostMapping("/crear")
	public ResponseEntity<PrendaDTOsinLista> creadPrenda(@RequestBody PrendaDTOsinLista prendaDto)
	{
		return ResponseEntity.status(HttpStatus.OK)
				.header("Content-Type", "application/json")
				.body(modelMapper.map(prendaService.crearPrenda(prendaDto), PrendaDTOsinLista.class));
	}

	@GetMapping("/{idPrenda}")
	public ResponseEntity<PrendaDTOsinLista> obtenerPrenda(@PathVariable Long idPrenda)
	{
		return ResponseEntity.status(HttpStatus.OK)
				.header("Content-Type", "application/json")
				.body(modelMapper.map(prendaService.obtenerPrenda(idPrenda), PrendaDTOsinLista.class));
	}

	@GetMapping("/lista")
	public ResponseEntity<List<PrendaDTOsinLista>> obtenerPrendasPaginadas(@RequestParam Integer index,
																		   @RequestParam Integer count)
	{
		return  ResponseEntity.status(HttpStatus.OK)
				.header("Content-Type", "application/json")
				.body(prendaService.obtenerPrendaPaginadas(index, count));
	}

	@PutMapping("/{idPrenda}")
	public ResponseEntity<PrendaDTOsinLista> editarPrenda(@PathVariable Long idPrenda,
														  @RequestBody PrendaDTOsinLista prendaDto)
	{
		return ResponseEntity.status(HttpStatus.OK)
				.header("Content-Type", "application/json")
				.body(modelMapper.map(prendaService.editarPrenda(idPrenda, prendaDto), PrendaDTOsinLista.class));
	}

	@GetMapping("/buscar")
	ResponseEntity<List<PrendaDTOsinLista>> obtenerPrendasPaginadas(@RequestParam String cadena,
																	@RequestParam Integer index,
																	@RequestParam Integer count)
	{
		return ResponseEntity.status(HttpStatus.OK)
				.header("Content-Type", "application/json")
				.body(prendaService.buscarPrendas(cadena, index, count));
	}
}
