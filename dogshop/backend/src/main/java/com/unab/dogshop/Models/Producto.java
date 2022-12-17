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
@Table(name= "producto")
public class Producto implements Serializable{
    
    @Id
    @GeneratedValue(generator ="UUID")
    @GenericGenerator(name ="UUID", strategy = "org.hibernate.id.UUIDGenerator")

    @Column(name ="id",length = 50)
    private String id;
    
    @Column(name ="descripcion",length = 90)
    private String descripcion;

    @Column(name ="valor",length = 50)
    private String valor;

    @ManyToOne
    @JoinColumn(name="id_categoria")
    private Categoria categoria;

    @Column(name ="imagen",length = 200)
    private String imagen;

    @Override
    public String toString(){
      return "Producto [id=" + id + " descripcion="+ descripcion + " valor="+
      valor + " id_categoria=" + categoria.getId() + "]" ;

    } 

}
