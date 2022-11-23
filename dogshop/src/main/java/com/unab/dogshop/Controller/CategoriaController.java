package com.unab.dogshop.Controller;

import com.unab.dogshop.Service.CategoriaService;
import com.unab.dogshop.Models.Categoria;
//import com.unab.dogshop.Models.Message;
//import com.unab.dogshop.Repositories.CategoriaRepository;

//import com.unab.dogshop.Security.Hash;
//import com.unab.dogshop.Utility.ConvertEntity;
import com.unab.dogshop.Dto.CategoriaDto;

import java.util.ArrayList;
import java.util.List;
//import java.lang.Exception;

//import java.util.ArrayList;
//import java.util.List;
//import java.lang.Exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/categoria")
public class CategoriaController {
        @Autowired
        CategoriaService categoriaService;

        @PostMapping("/create")
        @ResponseBody       
        public Categoria save(@RequestBody Categoria categoria){
            return categoriaService.save(categoria);
        }

                
        @GetMapping("/list")
        public ResponseEntity<List<CategoriaDto>>  findAll() {
            List<Categoria> categorias = categoriaService.findAll();
            List<CategoriaDto> categoriasDto = new ArrayList<>();
            for (Categoria categoria : categorias) {
                CategoriaDto categoriaDto = new CategoriaDto();
                categoriaDto.setId(categoria.getId());
                categoriaDto.setNombre(categoria.getNombre());
                categoriaDto.setDescripcion(categoria.getDescripcion());

                categoriasDto.add(categoriaDto);
            }
            
            return new ResponseEntity<>(categoriasDto, HttpStatus.OK);
    
        }
    }