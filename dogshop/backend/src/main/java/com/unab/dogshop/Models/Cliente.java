package com.unab.dogshop.Models;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  
   // @Column(name="id", length=50, nullable = false)
    @Column(name="id", length=50)
    private String id;
    
    //@Column(name= "nombre", length=50,nullable = false)
    @Column(name= "nombre", length=50)
    private String nombre;
    
    //@Column(name= "direccion",length=50,nullable = false)
    @Column(name= "direccion",length=50)
    private String direccion;
    
    //@Column(name= "telefono", length=90,nullable = false)
    @Column(name= "telefono", length=90)
        private String telefono;
    
    //@Column(name="email", length=90,nullable = false)
    @Column(name="email", length=90)
    private String email;

    //@Column(name="clave",length=90,nullable = false)
    @Column(name="clave",length=90)
    private String clave;

    //@Column(name= "userName",length=90,nullable = false)
    @Column(name= "userName",length=90)
    private String userName;


    @OneToMany(mappedBy="cliente")
    private List <Factura> facturas;

   

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "clientes_roles", joinColumns = @JoinColumn(name = "cliente_id"),
     inverseJoinColumns = @JoinColumn(name = "role_id"))
     private Set<Role> roles = new HashSet<>();

    @Override
    public String toString() {
        return "Cliente [idCliente=" + id + ", nombreCliente=" + nombre + ", telefono=" + telefono + ", email=" + email + ", direccion=" + direccion + ", telefono=" + telefono + ", clave=" + clave + "]";
    }

}
