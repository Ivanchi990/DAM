package add.bedam.controladores;

import add.bedam.servicios.CategoriaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categoria")
public class CategoriaControlador
{
	@Autowired
	ModelMapper modelMapper = new ModelMapper();
	@Autowired
	CategoriaService categoriaService;

	@DeleteMapping("/{id}")
	public ResponseEntity<String> borrarCategoria(@PathVariable Long id)
	{
		return ResponseEntity.status(categoriaService.eliminarCategoria(id))
				.header("Content-Type", "application/json")
				.body("");
	}
}
