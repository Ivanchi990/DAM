package com.chollapi.chollapi.controlador;

import com.chollapi.chollapi.dto.OfertaDto;
import com.chollapi.chollapi.modelo.Oferta;
import com.chollapi.chollapi.service.OfertaService;
import com.chollapi.chollapi.utils.ExtraUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/oferta")
public class OfertaController
{
    @Autowired
    private OfertaService ofertaService;
    private ExtraUtils extraUtils = new ExtraUtils();

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<String> obtenerOfertaID(@RequestParam(value = "idOferta", defaultValue = "0") Long id)
    {
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(extraUtils.toJson(ofertaService.obtenerOfertaID(id)));
    }
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> crearOferta(@RequestBody OfertaDto ofertaDto)
    {
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(extraUtils.toJson(ofertaService.crearOferta(ofertaDto)));
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<String> modificarOferta(@RequestBody Oferta oferta)
    {
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(extraUtils.toJson(ofertaService.modificarOferta(oferta)));
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> eliminarOferta(@RequestParam(value = "idOferta", defaultValue = "0") Long id)
    {
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(ofertaService.eliminarOferta(id));
    }

    @RequestMapping(method = RequestMethod.GET, value = {"/ultimas5ofertas"})
    public ResponseEntity<String> ultimas5(@RequestParam(value = "idProducto", defaultValue = "0") Long idProducto)
    {
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(extraUtils.toJson(ofertaService.ultimas5(idProducto)));
    }

    @RequestMapping(method = RequestMethod.GET, value = {"/ultimas5"})
    public ResponseEntity<String> ultimas5Categoria(@RequestParam(value = "idCategoria", defaultValue = "0") Long idCategoria)
    {
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(extraUtils.toJson(ofertaService.ultimas5Categoria(idCategoria)));
    }

    @RequestMapping(method = RequestMethod.GET, value = {"/list"}, params = {"page", "count"})
    public ResponseEntity<String> ultimasOfertas(@RequestParam(name ="count", defaultValue = "5") int count,
                                                 @RequestParam(name = "page", defaultValue = "0") int page,
                                                 @SortDefault(sort = "fechaPublicacion", direction = Sort.Direction.DESC) Sort sort)
    {
        Pageable pageable = PageRequest.of(page, count, sort);

        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(extraUtils.toJson(ofertaService.ultimasOfertas(pageable)));
    }
}
