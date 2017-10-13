
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import javax.persistence.EntityManager;
import swingdemo.model.Agenda;
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
public class CrearAgenda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EntityManager em =  HibernateUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        Cliente c = em.createQuery("From Cliente c ", Cliente.class).getResultList().get(0);
        Date fecha = new Date();
        Calendar calendario ;
        for (int i = 0; i < 10; i++) {
                Agenda a = new Agenda();
                a.setCliente(c);
                a.setFechaConsulta(fecha);
                a.setHora(fecha);
                em.persist(a);
        }
        em.getTransaction().commit();
    }
}
