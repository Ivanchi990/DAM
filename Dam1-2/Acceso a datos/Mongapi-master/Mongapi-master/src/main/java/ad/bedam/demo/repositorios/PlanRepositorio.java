package ad.bedam.demo.repositorios;

import ad.bedam.demo.entidades.Plan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface PlanRepositorio extends MongoRepository<Plan, Long>
{
    @Query("{'idUsuario' : ?0}")
    Plan unirsePlan(Long idUsuario, Long idPlan);
    @Query("{'idUsuario' : ?0}")
    Plan borrarsePlan(Long idUsuario, Long idPlan);
}