package com.unab.dogshop.Controller;

import com.unab.dogshop.Service.ClienteService;
import com.unab.dogshop.Models.Cliente;
import com.unab.dogshop.Models.Message;
import com.unab.dogshop.Repositories.ClienteRepository;
import com.unab.dogshop.Security.Hash;
import com.unab.dogshop.Utility.ConvertEntity;
import com.unab.dogshop.Dto.ClienteDto;

import java.util.ArrayList;
import java.util.List;
import java.lang.Exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    ConvertEntity convertEntity = new ConvertEntity();

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<Message> agregar (@RequestBody Cliente cliente){
        try {
            if (cliente.getNombre() == null) {
                return new ResponseEntity<Message>(new Message(401, "El campo nombre es obligatorio"),
                        HttpStatus.BAD_REQUEST);
            }
            cliente.setClave(Hash.sha1(cliente.getClave()));
            clienteService.save(cliente);
            return new ResponseEntity<Message>(new Message(201, "Registro Creado de forma satisfactoria"),
                    HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<Message>(new Message(400, "Los datos ingresados no son correctos"),
                    HttpStatus.BAD_REQUEST);
        }

    } 

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Message> deleteById(@PathVariable String id) {
        Message message = clienteService.deleteById(id);
        return new ResponseEntity<>(message, HttpStatus.resolve(message.getStatus()));
    }

    @PutMapping("/update")
    public ResponseEntity<Message> update(@RequestBody Cliente cliente) {

        try {
            if (cliente.getNombre() == null) {
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

    @GetMapping("/list")
    public ResponseEntity<List<ClienteDto>>  findAll() {
        List<Cliente> clientes = clienteService.findAll();
        List<ClienteDto> clientesDto = new ArrayList<>();
        for (Cliente cliente : clientes) {
            ClienteDto clienteDto = new ClienteDto();
            clienteDto.setId(cliente.getId());
            clienteDto.setNombre(cliente.getNombre());
            clienteDto.setEmail(cliente.getEmail());
            clienteDto.setDireccion(cliente.getDireccion());
            clienteDto.setTelefono(cliente.getTelefono());
            //clienteDto.setClave(cliente.getClave());
            clientesDto.add(clienteDto);

        }

        return new ResponseEntity<>(clientesDto, HttpStatus.OK);

    }




}
