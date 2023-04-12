package add.bedam.repositorios;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import add.bedam.entidades.Prenda;

import java.util.List;

@Repository
public interface PrendaRepository extends JpaRepository<Prenda, Long>
{
    Page<Prenda> findByNombreContaining(String nombre, Pageable pageable);
}
