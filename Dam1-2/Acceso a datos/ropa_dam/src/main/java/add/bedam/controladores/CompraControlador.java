package add.bedam.controladores;

import add.bedam.dto.PrendaDTOsinLista;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import add.bedam.dto.CompraDto;
import add.bedam.servicios.CompraService;

@RestController
@RequestMapping("/compra")
public class CompraControlador
{
	@Autowired
	ModelMapper modelMapper = new ModelMapper();
	@Autowired
	CompraService compraService;

	@PostMapping("/crear")
	public ResponseEntity<CompraDto> crearCompra(@RequestBody CompraDto compraDto)
	{
		return ResponseEntity.status(HttpStatus.OK)
				.header("Content-Type", "application/json")
				.body(compraService.convertirACompraDTO(compraService.crearCompra(compraDto)));
	}

	@GetMapping("/devolverPrenda")
	public ResponseEntity<CompraDto> devolverPrenda(@RequestParam Long idCompra, @RequestParam Long idPrenda)
	{
		return null;
	}
}
