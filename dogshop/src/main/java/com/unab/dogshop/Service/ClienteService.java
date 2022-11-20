package com.unab.dogshop.Service;

@Service
public class ClienteService {
    
    @Autowired 
    ClienteRepository clienteRepository;
    
    public Cliente save (Cliente cliente){
        return clienteRepository.save(cliente);
    
    }

    

