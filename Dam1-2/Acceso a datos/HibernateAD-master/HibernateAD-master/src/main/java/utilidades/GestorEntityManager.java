package utilidades;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GestorEntityManager
{
    private static final String PERSISTENCE_UNIT_NAME = "MavenJPA";

    private static EntityManagerFactory factory;

    public static EntityManagerFactory getEntityManagerFactory()
    {
        if(factory == null)
        {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        return factory;
    }

    public static void closeEntityManagerFactory()
    {
        if (factory != null) {
            factory.close();
        }
    }
}
