package com.unab.dogshop.Models;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name= "factura")
public class Factura implements Serializable{
    
    @Id
    @GeneratedValue(generator ="UUID")
    @GenericGenerator(name ="UUID", strategy = "org.hibernate.id.UUIDGenerator")

    @Column(name ="id",length = 50)
    private String id;
    
    @Column(name ="fecha",length = 50)
    private String fecha;

    @Column(name ="descripcion",length = 90)
    private String descripcion;

    @Column(name ="total",length = 50)
    private String total;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente cliente;

    @OneToMany(mappedBy="factura")
    private List <Item> items;

     @Override
    public String toString(){
      return "Factura [id=" + id + "fecha" 
      + fecha + "descripcion"+ descripcion + "total"+
      total + "id_cliente"+ cliente + "]" ;

    } 


}
