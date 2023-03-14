package com.chollapi.chollapi.controlador;

import com.chollapi.chollapi.modelo.Categoria;
import com.chollapi.chollapi.service.CategoriaService;
import com.chollapi.chollapi.utils.ExtraUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categoria")
public class CategoriaController
{
    @Autowired
    private CategoriaService categoriaService;
    private ExtraUtils extraUtils = new ExtraUtils();

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<String> obtenerCategoriaID(@RequestParam(value = "idCategoria", defaultValue = "1") Long id)
    {
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(extraUtils.toJson( categoriaService.obtenerCategoriaID(id)));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> crearCategoria(@RequestBody Categoria categoria)
    {
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(extraUtils.toJson( categoriaService.crearCategoria(categoria)));
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<String> modificarCategoria(@RequestBody Categoria categoria)
    {
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(extraUtils.toJson( categoriaService.modificarCategoria(categoria)));
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<String> eliminarCategoria(@RequestParam(value = "idCategoria", defaultValue = "0") Long id)
    {
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(extraUtils.toJson(categoriaService.eliminarCategoria(id)));
    }

    @RequestMapping(method = RequestMethod.GET, value = {"/ultimos5productos"})
    public ResponseEntity<String> ultimos5(@RequestParam(value = "idCategoria", defaultValue = "0") Long idCategoria)
    {
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(extraUtils.toJson(categoriaService.ultimos5(idCategoria)));
    }
}
