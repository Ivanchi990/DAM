package org.example;

import controller.OfertasController;
import modelos.Oferta;
import modelos.Producto;
import utilidades.GestorEntityManager;

import javax.persistence.EntityManager;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MainPrueba
{
    public static void main(String[] args)
    {
        EntityManager em = null;

        try
        {
            em = GestorEntityManager.getEntityManagerFactory().createEntityManager();

            Oferta oferta = new Oferta();
            oferta.setDisponible(true);
            oferta.setPrecio(12.3f);
            oferta.setUrl("jauja");
            String fecha = "12/02/2023";
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaDate = formatoFecha.parse(fecha);
            oferta.setFechaPublicacion(fechaDate);

            Oferta oferta2 = new Oferta();
            oferta2.setDisponible(true);
            oferta2.setPrecio(12.3f);
            oferta2.setUrl("jaujdawa");
            oferta2.setFechaPublicacion(fechaDate);

            Oferta oferta3 = new Oferta();
            oferta3.setDisponible(true);
            oferta3.setPrecio(12.3f);
            oferta3.setUrl("jaudwadja");
            oferta3.setFechaPublicacion(fechaDate);

            Producto producto = new Producto();
            producto.setNombre("juan");
            producto.setIdFabricante(2L);

            Producto producto2 = new Producto();
            producto2.setNombre("juani");
            producto2.setIdFabricante(3L);

            Producto producto3 = new Producto();
            producto3.setNombre("juanito");
            producto3.setIdFabricante(1L);

            oferta.anadirProducto(producto);
            oferta2.anadirProducto(producto2);
            oferta3.anadirProducto(producto3);

            Oferta oferta4 = new Oferta();
            oferta4.setDisponible(true);
            oferta4.setPrecio(12.3f);
            oferta4.setUrl("jauja");
            String fecha2 = "12/02/2022";
            SimpleDateFormat formatoFecha2 = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaDate2 = formatoFecha2.parse(fecha2);
            oferta4.setFechaPublicacion(fechaDate2);

            oferta4.anadirProducto(producto);

            OfertasController oc = new OfertasController();
            oc.crearOferta(oferta);
            oc.crearOferta(oferta2);
            oc.crearOferta(oferta3);
            List<Oferta> ofertitas= oc.ultimas5(producto);
            List<Oferta> ofertas = oc.ultimas10();

            int hola = ofertas.size();
            hola = ofertitas.size();

        }
            catch(Exception e)
        {
            if (em != null) {
                e.printStackTrace();
                System.out.println("Se va a hacer rollback de la transacción");
                em.getTransaction().rollback();
            }
            System.err.println(e.getMessage());
        }
    }
}