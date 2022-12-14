package com.unab.dogshop.Controller;

import com.unab.dogshop.Service.ProductoService;
import com.unab.dogshop.Models.Producto;
//import com.unab.dogshop.Models.Message;
//import com.unab.dogshop.Repositories.CategoriaRepository;

//import com.unab.dogshop.Security.Hash;
//import com.unab.dogshop.Utility.ConvertEntity;
import com.unab.dogshop.Dto.ProductoDto;

import java.util.ArrayList;
import java.util.List;
//import java.lang.Exception;
import java.util.Optional;

//import java.util.ArrayList;
//import java.util.List;
//import java.lang.Exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.unab.dogshop.Utility.ConvertEntity;






@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/producto")



public class ProductoController {
 

    @Autowired
    ProductoService productoService;
    @Autowired
    ConvertEntity convertEntity = new ConvertEntity();

 ProductoDto productoDto = new ProductoDto();

    @PostMapping("/create")
    @ResponseBody       
    public Producto save(@RequestBody Producto producto){
        return productoService.save(producto);
    }

            
    @GetMapping("/list")
    //public ResponseEntity<List<CategoriaDto>>  findAll() {
        public List<ProductoDto>  findAll() {

        List<Producto> productos = productoService.findAll();
        List<ProductoDto> productosDto = new ArrayList<>();
        for (Producto producto : productos) {
            /*CategoriaDto categoriaDto = new CategoriaDto();
            categoriaDto.setId(categoria.getId());
            categoriaDto.setNombre(categoria.getNombre());
            categoriaDto.setDescripcion(categoria.getDescripcion());
            */
            ProductoDto productoDto = new ProductoDto();
            productosDto.add((ProductoDto) convertEntity.convert(producto, productoDto));
 
            //categoriasDto.add(categoriaDto);
        }
        return productosDto;
        //return new ResponseEntity<>(categoriasDto, HttpStatus.OK);

    }



    @GetMapping("/list/{id_categoria}")
    public  List<ProductoDto> findByIdCategoria(@PathVariable String id_categoria,@RequestHeader String user, @RequestHeader String key){

            List<Producto> productos = productoService.findByIdCategoria(id_categoria);
            List<ProductoDto> productosDto = new ArrayList<>();
            for (Producto producto : productos) {
                /*CategoriaDto categoriaDto = new CategoriaDto();
                categoriaDto.setId(categoria.getId());
                categoriaDto.setNombre(categoria.getNombre());
                categoriaDto.setDescripcion(categoria.getDescripcion());
                */
                ProductoDto productoDto = new ProductoDto();
                productosDto.add((ProductoDto) convertEntity.convert(producto, productoDto));
     
                //categoriasDto.add(categoriaDto);
            }
            return productosDto;
          //return new ResponseEntity<>(categoriasDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object>  findById(@PathVariable("id") String id, @RequestHeader String user, @RequestHeader String key ) {
        return new ResponseEntity<Object>((ProductoDto) convertEntity.convert(productoService.findById(id), productoDto),HttpStatus.OK);
    }




}
