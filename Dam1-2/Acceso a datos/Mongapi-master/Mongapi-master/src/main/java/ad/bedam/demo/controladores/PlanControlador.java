package ad.bedam.demo.controladores;

import ad.bedam.demo.entidades.Plan;
import ad.bedam.demo.servicios.PlanServicio;
import ad.bedam.demo.utilidades.JsonConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/plan")
public class PlanControlador
{
    @Autowired
    private PlanServicio planServicio;
    private JsonConverter jsonConverter = new JsonConverter();

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<String> obtenerPlanID(@RequestParam(value = "idPlan", defaultValue = "1") Long id)
    {
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(jsonConverter.toJson( planServicio.obtenerPlan(id)));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> crearPlan(@RequestBody Plan plan)
    {
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(jsonConverter.toJson( planServicio.crearPlan(plan)));
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<String> modificarPlan(@RequestBody Plan plan)
    {
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(jsonConverter.toJson( planServicio.actualizarPlan(plan)));
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<String> eliminarPlan(@RequestParam(value = "idPlan", defaultValue = "0") Long id)
    {
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(jsonConverter.toJson(planServicio.eliminarPlan(id)));
    }

    @RequestMapping(method = RequestMethod.POST, value = {"/unirse"})
    public ResponseEntity<String> desunirsePlan(@RequestParam(value = "idUsuario", defaultValue = "0") Long idUsuario,
                                                @RequestParam(value = "idPlan", defaultValue = "0") Long idPlan)
    {
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(jsonConverter.toJson(planServicio.borrarsePlan(idUsuario, idPlan)));
    }

    @RequestMapping(method = RequestMethod.POST, value = {"/borrarse"})
    public ResponseEntity<String> unirsePlan(@RequestParam(value = "idUsuario", defaultValue = "0") Long idUsuario,
                                             @RequestParam(value = "idPlan", defaultValue = "0") Long idPlan)
    {
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(jsonConverter.toJson(planServicio.unirsePlan(idUsuario, idPlan)));
    }
}
