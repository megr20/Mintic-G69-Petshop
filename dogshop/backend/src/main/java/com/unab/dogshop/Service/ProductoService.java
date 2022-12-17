package com.unab.dogshop.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;

//import com.unab.dogshop.Controller.Message;
import com.unab.dogshop.Models.Producto;
import com.unab.dogshop.Models.Categoria;
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


    public Producto save(Producto producto){
        return productoRepository.save(producto);
    }
 

    public List <Producto>findByIdCategoria(String id_categoria) {
        Categoria categoria = new Categoria();
        categoria.setId(id_categoria);
        return (List<Producto>) productoRepository.findByCategoria(categoria);
    }


    /*public List <Producto>findById(String id) {
        Producto producto = new Producto();
        producto.setId(id);
        return (List<Producto>) productoRepository.findById(producto);
    }*/
    public Producto findById(String id) {        
         return productoRepository.findById(id).get();
    }

//obtiene un solo producto por su id:
/* 
public Optional <Producto> findById(String id) {
        Optional <Producto> p = productoRepository.findById(id);
       //Optional <Producto> p = Optional.ofNullable(producto);
       return p;
       
}
*/
/* 
public Optional<Producto> findById(String valor) {
    return productoRepository.findById(valor);
}
*/


}