package com.unab.dogshop.Dto;

import java.util.Set;

//import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class CrearClienteDto {
    private String id;
    @Size(min = 5,message = "El campo requiere minimo 5 caracteres")
    private String nombre;
    private String userName;
    private String clave;
    private String direccion;
    private String telefono;
    private String email;
    //@Email(message = "El dato no tiene la estructura de un correo")
    //@Size(min=50,message = "El campo requiere mínimo 50 caracteres")
  
    private Set<String> roles;
}



