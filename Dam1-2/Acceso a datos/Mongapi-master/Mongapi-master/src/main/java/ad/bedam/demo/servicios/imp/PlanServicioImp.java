package ad.bedam.demo.servicios.imp;

import ad.bedam.demo.entidades.Plan;
import ad.bedam.demo.entidades.Usuario;
import ad.bedam.demo.repositorios.PlanRepositorio;
import ad.bedam.demo.repositorios.UsuarioRepositorio;
import ad.bedam.demo.servicios.PlanServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class    PlanServicioImp implements PlanServicio
{
    @Autowired
    private PlanRepositorio planRepositorio;
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Override
    public Plan obtenerPlan(Long idPlan) {
        return planRepositorio.findById(idPlan).get();
    }

    @Override
    public Plan actualizarPlan(Plan plan) {
        return planRepositorio.save(plan);
    }

    @Override
    public boolean eliminarPlan(Long idPlan) {
        planRepositorio.deleteById(idPlan);
        return true;
    }

    @Override
    public Plan crearPlan(Plan plan) {
        return planRepositorio.save(plan);
    }

    @Override
    public Plan unirsePlan(Long idUsuario, Long idPlan) {

        Plan plan = planRepositorio.findById(idPlan).get();
        Usuario usuario = usuarioRepositorio.findById(idUsuario).get();

        plan.getUsuarios().add(usuario);

        return planRepositorio.save(plan);
    }

    @Override
    public Plan borrarsePlan(Long idUsuario, Long idPlan) {
        Plan plan = planRepositorio.findById(idPlan).get();
        Usuario usuario = usuarioRepositorio.findById(idUsuario).get();

        plan.getUsuarios().remove(usuario);

        return planRepositorio.save(plan);
    }
}
