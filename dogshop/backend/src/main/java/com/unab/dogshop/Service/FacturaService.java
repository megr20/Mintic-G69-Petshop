package com.unab.dogshop.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;

import com.unab.dogshop.Models.Factura;
//import com.unab.dogshop.Models.Message;
import com.unab.dogshop.Repositories.FacturaRepository;
//import com.unab.dogshop.Security.Hash;
//import com.unab.dogshop.Utility.ConvertEntity;

//import scala.collection.mutable.ListBuffer;


import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional

public class FacturaService {
    
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    FacturaRepository facturaRepository;

    

    public List<Factura> findAll() {
        return (List<Factura>) facturaRepository.findAll();
    }


    public Optional<Factura> findByNombre(Factura factura) {
        return facturaRepository.findById(factura);
    }

    public Factura save(Factura factura){
        return facturaRepository.save(factura);
    }

}