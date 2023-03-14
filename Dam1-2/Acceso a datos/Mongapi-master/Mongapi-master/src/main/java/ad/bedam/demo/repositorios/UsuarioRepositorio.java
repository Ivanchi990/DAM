package ad.bedam.demo.repositorios;

import ad.bedam.demo.entidades.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepositorio extends MongoRepository<Usuario, Long>
{

}
