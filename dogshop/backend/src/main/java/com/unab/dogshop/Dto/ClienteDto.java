package com.unab.dogshop.Dto;

    
import java.util.List;

import com.unab.dogshop.Models.Role;

import lombok.Data;

@Data
public class ClienteDto {
    private String id;
    private String nombre;
    private String email;
    private String direccion;
    private String telefono;
    private String clave;
    private String userName;
    private List<Role> roles;
   
}

