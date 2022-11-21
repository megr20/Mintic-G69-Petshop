package com.unab.dogshop.Models;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "cliente")
public class Cliente implements Serializable{
    
    @Id
    @GeneratedValue(generator ="UUID")
    @GenericGenerator(name ="UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name ="id",length = 20)
    private String id;
    
    @Column(name ="nombre",length = 50)
    private String nombre;

    @Column(name ="direccion",length = 50)
    private String direccion;

    @Column(name ="email",length = 90)
    private String email;

    @Column(name ="telefono",length = 90)
    private String telefono;

    @Column(name ="clave",length = 10)
    private String clave;
    
/* 
    public Cliente(String idCliente, String nombre, 
      String direccion, String email, String telefono, String clave) {
      this.id = idCliente;
      this.nombre = nombre;
      this.direccion = direccion;
      this.email = email;
      this.telefono = telefono;
      this.clave = clave;

    }*/


    @Override
    public String toString(){
      return "Cliente [id=" + id + "nombre" 
      + nombre + "direccion"+ direccion + "email"+
        email + "telefono"+ telefono + "clave" + clave + "]" ;

    } 


}
