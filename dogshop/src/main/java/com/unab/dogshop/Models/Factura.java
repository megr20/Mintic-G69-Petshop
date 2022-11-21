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
@Table(name= "factura")
public class Factura implements Serializable{
    
    @Id
    @GeneratedValue(generator ="UUID")
    @GenericGenerator(name ="UUID", strategy = "org.hibernate.id.UUIDGenerator")

    @Column(name ="id",length = 5)
    private String id;
    
    @Column(name ="fecha",length = 50)
    private String fecha;

    @Column(name ="descripcion",length = 90)
    private String descripcion;

    @Column(name ="total",length = 5)
    private String total;

    @ManyToOne
    @JoinColumn(name="id_cliente")
    private Cliente cliente;

    @Override
    public String toString(){
      return "Factura [id=" + id + "fecha" 
      + fecha + "descripcion"+ descripcion + "total"+
      total + "id_cliente"+ cliente + "]" ;

    } 


}
