package dao;

import modelos.Oferta;
import modelos.Producto;
import utilidades.GestorEntityManager;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class OfertaDAOImp extends GenericDAOImp<Oferta,Long> implements  OfertaDAO
{
    @Override
    public List<Oferta> ultimas5(Producto producto)
    {
        EntityManager em = GestorEntityManager.getEntityManagerFactory().createEntityManager();
        TypedQuery<Oferta> q = em.createQuery("SELECT o FROM Oferta o JOIN Producto p WHERE p.idProducto = :idProc ORDER BY o.fechaPublicacion DESC", Oferta.class);

        q.setParameter("idProc", producto.getIdProducto()).setMaxResults(5);

        return q.getResultList();
    }

    @Override
    public List<Oferta> ultimas10()
    {
        EntityManager em = GestorEntityManager.getEntityManagerFactory().createEntityManager();
        TypedQuery<Oferta> q = em.createQuery("SELECT o FROM Oferta o ORDER BY o.fechaPublicacion DESC", Oferta.class).setMaxResults(10);

        return q.getResultList();
    }
}