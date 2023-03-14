package com.chollapi.chollapi.service.impl;

import com.chollapi.chollapi.dto.OfertaDto;
import com.chollapi.chollapi.modelo.Oferta;
import com.chollapi.chollapi.modelo.Producto;
import com.chollapi.chollapi.repositorio.OfertaRepository;
import com.chollapi.chollapi.repositorio.ProductoRepository;
import com.chollapi.chollapi.service.OfertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class OfertaServiceImpl implements OfertaService
{
    @Autowired
    private OfertaRepository ofertaRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public Oferta obtenerOfertaID(Long id) {
        return ofertaRepository.findById(id).orElse(null);
    }

    @Override
    public Oferta crearOferta(OfertaDto ofertaDto)
    {
        if(existeOferta(ofertaDto))
        {
            return null;
        }

        Oferta oferta = new Oferta(ofertaDto.getUrl(), ofertaDto.getFechaPublicacion(), ofertaDto.getPrecio(), ofertaDto.getDisponible());
        oferta.addProducto(productoRepository.findById(ofertaDto.idProducto).get());

        return ofertaRepository.save(oferta);
    }

    private boolean existeOferta(OfertaDto ofertaDto)
    {
        Date fechaOferta;
        String url;
        Float precio;
        Boolean disponible;

        for(Oferta o: ofertaRepository.findAll())
        {
            fechaOferta = o.getFechaPublicacion();
            url = o.getUrl();
            precio = o.getPrecio();
            disponible = o.getDisponible();

            if(fechaOferta.equals(ofertaDto.getFechaPublicacion()))
            {
                if(url.equals(ofertaDto.getUrl()))
                {
                    if(precio.equals(ofertaDto.getPrecio()))
                    {
                        if(disponible.equals(ofertaDto.getDisponible()))
                        {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    @Override
    public Oferta modificarOferta(Oferta oferta)
    {
        return ofertaRepository.save(oferta);
    }

    @Override
    public Boolean eliminarOferta(Long id)
    {
        ofertaRepository.deleteById(id);

        return !ofertaRepository.existsById(id);
    }


    @Override
    public List<Oferta> ultimas5(Long idProducto)
    {
        return ofertaRepository.ultimas5(idProducto);
    }

    @Override
    public List<OfertaDto> ultimasOfertas(Pageable pageable)
    {
        List<OfertaDto> ofertasDtos = new ArrayList<>();

        for (Oferta o: ofertaRepository.findAll(pageable))
        {
            ofertasDtos.add(new OfertaDto(o.getIdOferta(), o.getUrl(), o.getFechaPublicacion(), o.getPrecio(), o.getDisponible()));
        }

        return ofertasDtos;
    }

    @Override
    public List<Oferta> ultimas5Categoria(@Param("idCategoria") Long idCategoria)
    {
        return ofertaRepository.ultimas5Categoria(idCategoria);
    }
}


