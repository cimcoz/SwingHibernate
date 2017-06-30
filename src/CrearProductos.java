
import org.hibernate.Session;
import swingdemo.model.Producto;
import swingdemo.util.HibernateUtil;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author marcelo
 */
public class CrearProductos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Session currentSession = (Session) HibernateUtil.getSessionFactory().openSession();

        
        //Crear 10 pedidos para clientes

        currentSession.beginTransaction();
        
            for (int i = 0; i < 100; i++) {
                Producto p = new Producto();
                p.setNombre("producto "+i);
                p.setDescripcion("descripcion "+i);
                p.setPrecio(Math.random() * 100);
                p.setIva(10);
                currentSession.persist(p);
            }
        
        currentSession.getTransaction().commit();
        
    }
}
