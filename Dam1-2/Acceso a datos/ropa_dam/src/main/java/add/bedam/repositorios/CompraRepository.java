package add.bedam.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import add.bedam.entidades.Compra;
	
@Repository
public interface CompraRepository extends CrudRepository<Compra, Long>
{

}
