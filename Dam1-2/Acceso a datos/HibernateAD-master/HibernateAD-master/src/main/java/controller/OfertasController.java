package controller;

import dao.OfertaDAO;
import dao.OfertaDAOImp;
import modelos.Oferta;
import modelos.Producto;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.transaction.Transactional;

public class OfertasController
{
    private final static Logger LOGGER = Logger.getLogger(OfertasController.class.getName());

    OfertaDAO ofertaDAO;

	public OfertasController()
    {
        ofertaDAO = new OfertaDAOImp();
    }

    @Transactional
    public void crearOferta(Oferta oferta)
    {
        List<Oferta> listOfertas = ofertaDAO.findAll();

        if(comprobarObjetos(listOfertas, oferta))
        {
            LOGGER.log(Level.WARNING, "Oferta repe nene");
        }
        else
        {
            ofertaDAO.persist(oferta);
        }
    }


    public boolean comprobarObjetos(List<Oferta> ofertas, Oferta oferta)
    {
        boolean coincide = false;

        for(Oferta o: ofertas)
        {
            if(oferta.equals(o))
            {
                coincide = true;
            }
        }

        return coincide;
    }


    public List<Oferta> ultimas5(Producto producto)
    {
        return ofertaDAO.ultimas5(producto);
    }

    public List<Oferta> ultimas10()
    {
        return ofertaDAO.ultimas10();
    }
}
