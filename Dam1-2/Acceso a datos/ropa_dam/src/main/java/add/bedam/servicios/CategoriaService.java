package add.bedam.servicios;

import org.springframework.http.HttpStatus;

public interface CategoriaService
{
    public HttpStatus eliminarCategoria(Long idCategoria);
}
