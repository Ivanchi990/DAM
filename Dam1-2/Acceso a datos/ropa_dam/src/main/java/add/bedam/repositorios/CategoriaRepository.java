package add.bedam.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import add.bedam.entidades.Categoria;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Long>
{
	
}
