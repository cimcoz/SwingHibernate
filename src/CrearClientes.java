
import java.util.Date;
import java.util.Random;
import org.hibernate.Session;
import swingdemo.model.Cliente;
import swingdemo.model.Pedido;
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
        Session currentSession = (Session) HibernateUtil.getSessionFactory().openSession();
        currentSession.beginTransaction();
        for (int i = 0; i < 10; i++) {
                Cliente c = new Cliente();
                c.setNombre("Nuevo");
                c.setApellido("Apellido: " + new Random(i).nextInt() );
                c.setActivo(false);
                c.setCreatedOn(new Date());
                currentSession.persist(c);
        }
        currentSession.getTransaction().commit();
    }
}
