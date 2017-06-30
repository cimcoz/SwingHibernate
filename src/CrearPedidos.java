
import java.util.List;
import java.util.Random;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import swingdemo.model.Cliente;
import swingdemo.model.Pedido;
import swingdemo.util.HibernateUtil;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author marcelo
 */
public class CrearPedidos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EntityManager em =  HibernateUtil.getSessionFactory().createEntityManager();
        

        List<Cliente> clientesList = em.createQuery("From Cliente").getResultList();

        //Crear 10 pedidos para clientes

        em.getTransaction().begin();
        for (Cliente c : clientesList) {
            for (int i = 0; i < 10; i++) {
                Pedido p = new Pedido();
                p.setCliente(c);
                p.setNombre("Pedido: " + new Random(i).nextInt() );
                em.persist(p);
            }
        }
        em.getTransaction().commit();
    }
}
