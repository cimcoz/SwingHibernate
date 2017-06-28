/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package swingdemo.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.*;

/**
 *
 * @author marcelo
 * Crear un cliente
 */
@Entity
public class Cliente implements Serializable {
    
    
    private Long            id;
    private String          nombre;
    private String          apellido;
    private Tipo            tipo;
    private Date            createdOn;
    private Boolean         activo;
    
    
    private Set<Pedido> pedidos;
    
    @Temporal(TemporalType.DATE)
    @Column(name="created_on", updatable=false, nullable=false)
    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date created_on) {
        this.createdOn = created_on;
    }
    
    
    @ManyToMany(fetch= FetchType.LAZY, mappedBy="cliente")
    public Set<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(Set<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
    

    public Cliente() {
    }
    
   
    @Column(name="apellido")
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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
    
    @OneToOne
    @JoinColumn(name="tipo_id" )
    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    
    @Column
    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
    
    

    public Cliente(Long id, String nombre, String apellido, Tipo tipo, Date createdOn, Set<Pedido> pedidos) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipo = tipo;
        this.createdOn = createdOn;
        this.pedidos = pedidos;
    }
    
    
    
    
    
}

