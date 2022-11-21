package com.unab.dogshop.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unab.dogshop.Models.Cliente;
import com.unab.dogshop.Repositories.ClienteRepository;

//import scala.collection.mutable.ListBuffer;

@Service
public class ClienteService {
    
    @Autowired
    ClienteRepository clienteRepository;
    
    public Cliente save (Cliente cliente){
        return clienteRepository.save(cliente);
    }

    @Transactional(readOnly = false)
    public void delete (String id){
        clienteRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Cliente findById(String id){
        return clienteRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Cliente> findAll() {
        return (List<Cliente>) clienteRepository.findAll();
    }

    //@Transactional(readOnly = true)
    //public Cliente Login(String usuario, String clave) {
    //    return clienteRepository.login(usuario,clave);
    //}


}
    

