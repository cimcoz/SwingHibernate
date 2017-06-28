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
    
    private Long            id;
    private String          nombre;
    private String          descripcion;
    private Double          precio;
    private Integer         iva;
    private Set<Pedido>     pedidos;
    
    
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
    
    @ManyToMany(mappedBy="productos", fetch= FetchType.LAZY)
    @JoinTable(name="productos_pedidos", joinColumns = {@JoinColumn(name="pedido_id")}, inverseJoinColumns={@JoinColumn(name="producto_id")})
    public Set<Pedido> getPedidos(){
        return this.pedidos;
    }

    public void setPedidos(Set<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
    
    
    

    public Producto(Long id, String nombre, String descripcion, Double precio, Set<Pedido> clientes) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.pedidos = clientes;
    }

    public Producto() {
    }   
            
}
