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
@Table(name="pedido")
public class Pedido implements Serializable {
    
    
    private Long                    id;
    private Cliente                 cliente;
    private String                  nombre;
    private Set<ProductoPedido>     productoPedidos;

    public Pedido() {
    }

    
    public Pedido(Long id, Cliente cliente, String nombre) {
        this.id = id;
        this.cliente = cliente;
        this.nombre = nombre;
    }

    @ManyToOne
    @JoinColumn(name="cliente_id")
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY)
    @Column(name="id")
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

    @OneToMany (mappedBy="pedido")
    public Set<ProductoPedido> getProductoPedidos() {
        return productoPedidos;
    }

    public void setProductoPedidos(Set<ProductoPedido> productoPedidos) {
        this.productoPedidos = productoPedidos;
    }
    
    
    
    
    
    
}
