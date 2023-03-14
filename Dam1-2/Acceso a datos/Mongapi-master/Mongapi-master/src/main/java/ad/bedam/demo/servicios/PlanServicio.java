package ad.bedam.demo.servicios;

import ad.bedam.demo.entidades.Plan;

import java.util.List;

public interface PlanServicio
{
    Plan obtenerPlan(Long idPlan);
    Plan actualizarPlan(Plan plan);
    boolean eliminarPlan(Long idPlan);
    Plan crearPlan(Plan plan);

    Plan unirsePlan(Long idUsuario, Long idPlan);
    Plan borrarsePlan(Long idUsuario, Long idPlan);
}
