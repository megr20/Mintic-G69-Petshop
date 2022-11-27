package com.unab.dogshop.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

import com.unab.dogshop.Models.Cliente;
import com.unab.dogshop.Models.Message;
import com.unab.dogshop.Repositories.ClienteRepository;
import com.unab.dogshop.Security.Hash;
//import java.util.List;


//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;


import com.unab.dogshop.Models.Role;





@Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;

    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<Cliente> findAll() {
        return (List<Cliente>) clienteRepository.findAll();
    }

    public Message deleteById(String id) {
        try {
            clienteRepository.deleteById(id);
            return new Message(200, "Registro con id " + id + " eliminado");
        } catch (Exception e) {
            //TODO: handle exception
            return new Message(400, "No existe cliente con id " + id);
        }

    }

    public Message update(Cliente cliente) {
        cliente = clienteRepository.findById(cliente.getId()).get();
        System.out.println(cliente + "-------");
        if (!cliente.getId().equals("")) {
            cliente.setClave(Hash.sha1(cliente.getClave()));
            clienteRepository.save(cliente);
            return new Message(200, "ok");
        } else {
            return new Message(404, "Cliente no encontrado");
        }

    }

    public Cliente login(String user, String pwd) {
        return clienteRepository.login(user, pwd);
    }

    public Cliente findByUserName(String user) {
        return clienteRepository.findByUserName(user);
    }

    public Boolean validarCredenciales(String user, String key) {
        Cliente clienteC = clienteRepository.findByUserName(user);
        if (clienteC == null) {
            return false;
        } else {
            if (Hash.sha1(clienteC.getClave() + Hash.sha1(user)).equals(key)) {
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean validarUsuarioAdmin(String user, String key) {
        Cliente cliente = clienteRepository.findByUserName(user);
        System.out.println(cliente+"----------");
        if (!validarCredenciales(user, key)) {
            return false;
        }
        try {
            if (cliente.getUserName() == null) {
                return false;
            }
            int cantidad = 0;

            for (Role role : cliente.getRoles()) {
                if (role.getNombre().toString().equals("ROLE_ADMIN")) {
                    cantidad++;
                }

            }
            if (cantidad == 0) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}

