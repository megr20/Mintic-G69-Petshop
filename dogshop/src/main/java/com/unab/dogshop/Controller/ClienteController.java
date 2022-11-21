package com.unab.dogshop.Controller;

import com.unab.dogshop.Service.ClienteService;
import com.unab.dogshop.Models.Cliente;
import com.unab.dogshop.Repositories.ClienteRepository;

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

    @Autowired 
    ClienteRepository clienteRepository;

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<Cliente> agregar (@RequestBody Cliente cliente){
        Cliente obj = null;
        try{  
                obj = clienteService.save(cliente);
                return new ResponseEntity<>(obj,HttpStatus.OK);
        }
        catch(Exception exception){
            return  new ResponseEntity<>(obj,HttpStatus.BAD_REQUEST);
        }
    } 

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Cliente> eliminar(@PathVariable String id){
        Cliente obj = clienteService.findById(id);
        if(obj != null){
            clienteService.delete(id);
        }
        else
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(obj, HttpStatus.OK);    
    }
    @GetMapping(value = "/list")
    public List<Cliente> findAll(){
        return clienteService.findAll();
    }
}
