package com.chollapi.chollapi.controlador;

import com.chollapi.chollapi.dto.ProductoDto;
import com.chollapi.chollapi.service.ProductoService;
import com.chollapi.chollapi.utils.ExtraUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producto")
public class ProductoController
{
    @Autowired
    private ProductoService productoService;
    private ExtraUtils extraUtils = new ExtraUtils();

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<String> obtenerProductoID(@RequestParam(value = "idProducto", defaultValue = "0") Long id)
    {
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(extraUtils.toJson(productoService.obtenerProductoID(id)));
    }
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> crearProducto(@RequestBody ProductoDto productoDto)
    {
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(extraUtils.toJson(productoService.crearProducto(productoDto)));
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<String> modificarProducto(@RequestBody ProductoDto productoDto)
    {
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(extraUtils.toJson(productoService.modificarProducto(productoDto)));
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<String> eliminarProducto(@RequestParam(value = "idProducto", defaultValue = "0") Long id)
    {
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(extraUtils.toJson(productoService.eliminarProducto(id)));
    }

    @RequestMapping(method = RequestMethod.GET, value = {"/list"}, params = {"page", "count"})
    public ResponseEntity<String> listar5Pag(@RequestParam(name ="count", defaultValue = "5") int count,
                                             @RequestParam(name = "page", defaultValue = "0") int page)
    {
        Pageable pageable = PageRequest.of(page, count);

        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(extraUtils.toJson(productoService.listar5Pag(pageable)));
    }

    @RequestMapping(method = RequestMethod.GET, value = {"/mejores10oferta"})
    public ResponseEntity<String> mejores10(@RequestParam(value = "idProducto", defaultValue = "0") Long id)
    {
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(extraUtils.toJson(productoService.mejores10(id)));
    }

    @RequestMapping(method = RequestMethod.GET, value = {"/buscar"})
    public ResponseEntity<String> buscarProducto(@RequestParam (value = "texto", defaultValue = "0") String texto)
    {
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(extraUtils.toJson(productoService.buscarProducto(texto)));
    }

}
