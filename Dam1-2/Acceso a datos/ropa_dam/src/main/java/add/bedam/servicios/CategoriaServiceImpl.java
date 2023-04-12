package add.bedam.servicios;

import add.bedam.entidades.Categoria;
import add.bedam.repositorios.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl implements CategoriaService
{
    @Autowired
    CategoriaRepository categoriaRepository;

    @Override
    public HttpStatus eliminarCategoria(Long idCategoria)
    {
        Categoria categoria = categoriaRepository.findById(idCategoria).orElse(null);
        HttpStatus httpStatus;

        if(categoria != null)
        {
            if(categoria.getPrendas().size() > 0)
            {
                httpStatus = HttpStatus.CONFLICT;
            }
            else
            {
                categoriaRepository.deleteById(idCategoria);
                httpStatus = HttpStatus.OK;
            }
        }
        else
        {
            httpStatus = HttpStatus.NOT_FOUND;
        }

        return httpStatus;
    }
}
