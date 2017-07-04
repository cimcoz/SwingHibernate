
import java.util.List;
import javax.persistence.EntityManager;
import swingdemo.model.Cliente;
import swingdemo.model.Pedido;
import swingdemo.model.Producto;
import swingdemo.model.ProductoPedido;
import swingdemo.util.HibernateUtil;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author marcelo
 */
public class CrearProductoPedido {

    /**
     * @param args the command line arguments
     * Crear tres pedidos para el cliente 1
     *  cada pedido debe contener 10 productos
     *  
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EntityManager em =  HibernateUtil.getEntityManagerFactory().createEntityManager();
        Cliente c = em.find(Cliente.class, 2L);
        List<Producto> productos = em.createQuery("From Producto").getResultList();
        
        
        
        em.getTransaction().begin();
         
        for(int i=0;i<2 ;i++) {
            Pedido p = new Pedido();
            p.setCliente(c);
            p.setNombre("pedido: "+i);
            //Aqui voy a crear los pedidos
            for(int j = 0;j<20;j++) {
                ProductoPedido pp = new ProductoPedido();
                pp.setProducto(productos.get(j));
                System.out.println(productos.get(j));
                pp.setPedido(p);
                pp.setCantidad((double)j);
                pp.calcularSubTotales();
               
                
                //Calcular totales, esto podria estar en un trigger en la base de datos
                //El problema es que se delega la responsabilidad al dba que genere el codigo
                //para que la app funcione correctamente
//                Double totalIva = pp.getCantidad() * productos.get(j).getIva() * productos.get(j).getPrecio() / 100;
//                Double subTotal = pp.getCantidad() *  productos.get(j).getPrecio() ;
//                pp.setSubTotalIva(totalIva);
//                pp.setSubTotal(subTotal);
                
                em.persist(pp);
            }
            em.persist(p);
            
        }
        em.getTransaction().commit();
        
    }
}
