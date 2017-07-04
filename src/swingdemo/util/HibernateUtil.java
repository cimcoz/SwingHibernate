package swingdemo.util;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * The only purpose of this class is to provide a SessionFactory
 *
 * @author Christian Bauer
 */
public class HibernateUtil {

    private static final EntityManagerFactory entityManagerFactory;

    static {
        try {
            // Create the SessionFactory from a JPA configuration (persistence.xml)
            entityManagerFactory =
                    Persistence.createEntityManagerFactory("SwingHibernatePU");
            
            
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial EntityManagerFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static EntityManagerFactory getSessionFactory() {
        return entityManagerFactory;
    }

}
