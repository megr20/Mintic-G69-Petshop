package com.unab.dogshop.Models;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name= "item")
public class Item implements Serializable{
    
    @Id
    @GeneratedValue(generator ="UUID")
    @GenericGenerator(name ="UUID", strategy = "org.hibernate.id.UUIDGenerator")

    @Column(name ="id",length = 5)
    private String id;
    
    @Column(name ="nombre",length = 50)
    private String nombre;

    @Column(name ="descripcion",length = 90)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name="id_factura")
    private Factura factura;

    @ManyToOne
    @JoinColumn(name="id_producto")
    private Producto producto;

    @Override
    public String toString(){
      return "Factura [id=" + id + "nombre" 
      + nombre + "descripcion"+ descripcion + "id_factura"+
      factura + "id_producto"+ producto + "]" ;

    } 


}
