package ad.bedam.demo.controladores;

import ad.bedam.demo.entidades.Usuario;
import ad.bedam.demo.servicios.UsuarioServicio;
import ad.bedam.demo.utilidades.JsonConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioControlador
{
    @Autowired
    private UsuarioServicio usuarioServicio;
    private JsonConverter jsonConverter = new JsonConverter();

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<String> obtenerUsuarioID(@RequestParam(value = "idUsuario", defaultValue = "1") Long id)
    {
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(jsonConverter.toJson( usuarioServicio.obtenerUsuario(id)));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> crearUsuario(@RequestBody Usuario usuario)
    {
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(jsonConverter.toJson( usuarioServicio.crearUsuario(usuario)));
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<String> modificarUsuario(@RequestBody Usuario usuario)
    {
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(jsonConverter.toJson( usuarioServicio.actualizarUsuario(usuario)));
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<String> eliminarUsuario(@RequestParam(value = "idUsuario", defaultValue = "0") Long id)
    {
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(jsonConverter.toJson(usuarioServicio.eliminarUsuario(id)));
    }
}
