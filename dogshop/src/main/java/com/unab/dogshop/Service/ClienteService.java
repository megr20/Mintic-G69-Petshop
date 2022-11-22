package com.unab.dogshop.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unab.dogshop.Models.Cliente;
import com.unab.dogshop.Models.Message;
import com.unab.dogshop.Repositories.ClienteRepository;
import com.unab.dogshop.Security.Hash;
import com.unab.dogshop.Utility.ConvertEntity;

//import scala.collection.mutable.ListBuffer;

@Service
public class ClienteService {
    
    @Autowired
    ClienteRepository clienteRepository;
    
    public Cliente save (Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Message update(Cliente cliente) {
        cliente = clienteRepository.findById(cliente.getId()).get();
        System.out.println(cliente+"-------");
        if (!cliente.getId().equals("")) {
            cliente.setClave(Hash.sha1(cliente.getClave()));
            clienteRepository.save(cliente);
            return new Message(200, "ok");
        } else {
            return new Message(404, "Cliente no encontrado");
        }
    }

    @Transactional(readOnly = false)
    public Message deleteById(String id) {
        try {
            clienteRepository.deleteById(id);
            return new Message(200, "Registro con id " + id + " eliminado");
        } catch (Exception e) {
            // TODO: handle exception
            return new Message(400, "No existe cliente con id " + id);
        }
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
    

