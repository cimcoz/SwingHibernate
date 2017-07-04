
import java.util.Date;
import java.util.Random;
import javax.persistence.EntityManager;
import swingdemo.model.Cliente;
import swingdemo.util.HibernateUtil;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author marcelo
 */
public class CrearClientes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EntityManager em =  HibernateUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        for (int i = 0; i < 10; i++) {
                Cliente c = new Cliente();
                c.setNombre("Nuevo");
                c.setApellido("Apellido: " + new Random(i).nextInt() );
                c.setActivo(false);
                c.setCreatedOn(new Date());
                em.persist(c);
        }
        em.getTransaction().commit();
    }
}
