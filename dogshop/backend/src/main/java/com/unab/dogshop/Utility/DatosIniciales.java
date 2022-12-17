package com.unab.dogshop.Utility;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.unab.dogshop.Models.Cliente;
import com.unab.dogshop.Models.ERol;
import com.unab.dogshop.Models.Role;
import com.unab.dogshop.Repositories.RolRepository;
import com.unab.dogshop.Security.Hash;
import com.unab.dogshop.Service.ClienteService;
import com.unab.dogshop.Service.RolService;

@Component
public class DatosIniciales implements CommandLineRunner {
  

    @Autowired
    RolService rolService;

    @Autowired
    ClienteService clienteService;
    @Autowired
    RolRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {

        if (rolService.findAll().size() == 0) {
            Role rolAdmin = new Role(ERol.ROLE_ADMIN);
            Role rolUser = new Role(ERol.ROLE_USER);
            rolService.save(rolAdmin);
            rolService.save(rolUser);
            
        }
        if (clienteService.findAll().size() == 0) {
            Role userRole = roleRepository.findByNombre(ERol.ROLE_ADMIN).get();
            Set<Role> roles = new HashSet<>();
            roles.add(userRole);
            Cliente cliente = new Cliente();
            cliente.setNombre("admin");
            cliente.setUserName("admin");
            cliente.setClave(Hash.sha1("123456"));
            cliente.setRoles(roles);
            clienteService.save(cliente);
        }

    }
    
}


