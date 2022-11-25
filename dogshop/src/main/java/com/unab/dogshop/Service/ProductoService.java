package com.unab.dogshop.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;

import com.unab.dogshop.Models.Producto;
//import com.unab.dogshop.Models.Message;
import com.unab.dogshop.Repositories.ProductoRepository;
//import com.unab.dogshop.Security.Hash;
//import com.unab.dogshop.Utility.ConvertEntity;

//import scala.collection.mutable.ListBuffer;


import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional

public class ProductoService {
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ProductoRepository productoRepository;

    

    public List<Producto> findAll() {
        return (List<Producto>) productoRepository.findAll();
    }


    public Optional<Producto> findByNombre(Producto producto) {
        return productoRepository.findById(producto);
    }

    public Producto save(Producto producto){
        return productoRepository.save(producto);
    }

}