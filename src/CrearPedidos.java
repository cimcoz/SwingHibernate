
import java.util.List;
import java.util.Random;
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
        Session currentSession = (Session) HibernateUtil.getSessionFactory().openSession();

        List<Cliente> clientesList = currentSession.createCriteria(Cliente.class).list();

        //Crear 10 pedidos para clientes

        currentSession.beginTransaction();
        for (Cliente c : clientesList) {
            for (int i = 0; i < 10; i++) {
                Pedido p = new Pedido();
                p.setCliente(c);
                p.setNombre("Pedido: " + new Random(i).nextInt() );
                currentSession.persist(p);
            }
        }
        currentSession.getTransaction().commit();
    }
}
