package com.chollapi.chollapi.service;

import com.chollapi.chollapi.dto.OfertaDto;
import com.chollapi.chollapi.modelo.Oferta;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OfertaService
{
    Oferta obtenerOfertaID(Long id);

    Oferta crearOferta(OfertaDto ofertaDto);

    Oferta modificarOferta(Oferta oferta);

    Boolean eliminarOferta(Long id);

    List<Oferta> ultimas5(Long idProducto);

    List<OfertaDto> ultimasOfertas(Pageable pageable);

    List<Oferta> ultimas5Categoria(Long idCategoria);
}
