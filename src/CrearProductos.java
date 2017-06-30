
import javax.persistence.EntityManager;
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
        
       EntityManager em =  HibernateUtil.getSessionFactory().createEntityManager();

        
        //Crear 10 pedidos para clientes

        em.getTransaction().begin();
        
            for (int i = 0; i < 100; i++) {
                Producto p = new Producto();
                p.setNombre("producto "+i);
                p.setDescripcion("descripcion "+i);
                p.setPrecio(Math.random() * 100);
                p.setIva(10);
                em.persist(p);
            }
        
        em.getTransaction().commit();
        
    }
}
