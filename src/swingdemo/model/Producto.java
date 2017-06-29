/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package swingdemo.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;

/**
 *
 * @author marcelo
 */
@Entity
public class Producto implements Serializable {
    
    private Long                    id;
    private String                  nombre;
    private String                  descripcion;
    private Double                  precio;
    private Integer                 iva;
    private Set<ProductoPedido>     productoPedidos;
    
    
    @Column(name="descripcion")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name="precio")
    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    
    @OneToMany(fetch= FetchType.LAZY)
    public Set<ProductoPedido> getPedidos(){
        return this.productoPedidos;
    }

    public void setPedidos(Set<ProductoPedido> productoPedidos) {
        this.productoPedidos = productoPedidos;
    }

    public Integer getIva() {
        return iva;
    }

    public void setIva(Integer iva) {
        this.iva = iva;
    }
    
    
    

    public Producto(Long id, String nombre, String descripcion, Double precio, Set<ProductoPedido> productoPedidos) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.productoPedidos = productoPedidos;
    }

    public Producto() {
    }   
            
}
