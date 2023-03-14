package dao;

import modelos.Oferta;
import modelos.Producto;

import java.util.List;

public interface OfertaDAO extends GenericDAO<Oferta, Long>
{
    List<Oferta> ultimas5(Producto producto);

    List<Oferta> ultimas10();
}
