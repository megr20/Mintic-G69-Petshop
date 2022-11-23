package com.unab.dogshop.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;

import com.unab.dogshop.Models.Categoria;
//import com.unab.dogshop.Models.Message;
import com.unab.dogshop.Repositories.CategoriaRepository;
//import com.unab.dogshop.Security.Hash;
//import com.unab.dogshop.Utility.ConvertEntity;

//import scala.collection.mutable.ListBuffer;


import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;






@Service
@Transactional
public class CategoriaService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    CategoriaRepository categoriaRepository;

    

    public List<Categoria> findAll() {
        return (List<Categoria>) categoriaRepository.findAll();
    }


    public Optional<Categoria> findByNombre(Categoria categoria) {
        return categoriaRepository.findByNombre(categoria);
    }

    public Categoria save(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

}