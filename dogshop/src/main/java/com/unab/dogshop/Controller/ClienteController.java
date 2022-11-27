package com.unab.dogshop.Controller;

import com.unab.dogshop.Service.ClienteService;
import com.unab.dogshop.Models.Cliente;
import com.unab.dogshop.Models.Message;
import com.unab.dogshop.Security.Hash;
import com.unab.dogshop.Utility.ConvertEntity;
import com.unab.dogshop.Dto.ClienteDto;
import com.unab.dogshop.Dto.CrearClienteDto;
import com.unab.dogshop.Dto.CredencialesDto;
import com.unab.dogshop.Exception.Exception.InvalidDataException;

import java.util.ArrayList;
import java.util.List;
import java.lang.Exception;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.unab.dogshop.Service.RolService;

//import java.util.ArrayList;
import java.util.HashSet;
//import java.util.List;
import java.util.Set;

import javax.validation.Valid;


import org.springframework.validation.BindingResult;

import com.unab.dogshop.Models.Role;
import com.unab.dogshop.Models.ERol;


@RestController
@RequestMapping("/api/v1/cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    ConvertEntity convertEntity = new ConvertEntity();

    @Autowired
    RolService rolService;

    @PostMapping("/create")
    public ResponseEntity<Message> save(@Valid @RequestBody CrearClienteDto cliente, BindingResult result, @RequestHeader String user,
            @RequestHeader String key) {

                //return new ResponseEntity<Message>(new Message(200,user+key),HttpStatus.OK);
        
        if(result.hasErrors()){
            throw new InvalidDataException("Error de datos", result);
        }

        if (clienteService.validarUsuarioAdmin(user, key) == false) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        Set<String> strRoles = cliente.getRoles();
        Set<Role> roles = new HashSet<>();
        if (strRoles == null) {
            Role rol = rolService.findByNombre(ERol.ROLE_USER).get();
            roles.add(rol);
        } else {

            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role rolAdmin = rolService.findByNombre(ERol.ROLE_ADMIN).get();
                        roles.add(rolAdmin);
                        break;
                    case "user":
                        Role rolUser = rolService.findByNombre(ERol.ROLE_USER).get();
                        roles.add(rolUser);
                        break;
                    }
            });

        }

        Cliente clienteSave = (Cliente) convertEntity.convert(cliente, new Cliente());
        clienteSave.setRoles(roles);


        if (!clienteService.validarCredenciales(user, key)) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        try {
            if (cliente.getUserName() == null) {
                return new ResponseEntity<Message>(new Message(400, "El campo nombre es obligatorio"),
                        HttpStatus.BAD_REQUEST);
            }
            clienteSave.setClave(Hash.sha1(cliente.getClave()));
            clienteService.save(clienteSave);
            return new ResponseEntity<Message>(new Message(201, "Registro Creado de forma  satisfactoria"),
                    HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<Message>(new Message(400, "Los datos ingresados no    son correctos"),
                    HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping("/update")
    public ResponseEntity<Message> update(@Valid @RequestBody Cliente cliente, BindingResult result, @RequestHeader String user,
    @RequestHeader String key) {

        if(result.hasErrors()){
            throw new InvalidDataException("Error de datos", result);
        }

        if (clienteService.validarUsuarioAdmin(user, key) == false) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        
        try {
            if (cliente.getUserName() == null) {
                return new ResponseEntity<Message>(new Message(400, "El campo nombre es obligatorio"),
                        HttpStatus.BAD_REQUEST);
            }
            Message message = clienteService.update(cliente);
            return new ResponseEntity<Message>(new Message(message.getStatus(), message.getMessage()),
                    HttpStatus.valueOf(message.getStatus()));
        } catch (Exception e) {
            return new ResponseEntity<Message>(new Message(400, "Los datos ingresados no son correctos"),
                    HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/encriptar/{dato}")
    public String encriptar(@PathVariable String dato) {
        return Hash.sha1(dato);
    }

    @GetMapping
    public ResponseEntity<String> saludar() {
        return new ResponseEntity<>("Hola mundo", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Message> deleteById(@PathVariable String id) {
        Message message = clienteService.deleteById(id);
        return new ResponseEntity<>(message, HttpStatus.resolve(message.getStatus()));
    }

    @GetMapping("/list")
    public ResponseEntity<List<ClienteDto>> findAll(@RequestHeader String user, @RequestHeader String key) {

        if (!clienteService.validarCredenciales(user, key)) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        List<Cliente> clientes = clienteService.findAll();
        List<ClienteDto> clientesDto = new ArrayList<>();
        for (Cliente cliente : clientes) {
            ClienteDto clienteDto = new ClienteDto();
            clientesDto.add((ClienteDto) convertEntity.convert(cliente, clienteDto));
        }

        return new ResponseEntity<>(clientesDto, HttpStatus.OK);

    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestHeader String user, @RequestHeader String pwd) {
        Cliente cliente = clienteService.login(user, Hash.sha1(pwd));
        if (cliente != null) {
            return new ResponseEntity<>(new CredencialesDto(cliente.getUserName(),
                    Hash.sha1(Hash.sha1(pwd) + Hash.sha1(cliente.getUserName()))), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new Message(401, "Error de credenciales"), HttpStatus.UNAUTHORIZED);
        }

    }

   
}
