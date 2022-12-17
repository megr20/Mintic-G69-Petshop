package com.unab.dogshop.Controller;

import com.unab.dogshop.Service.FacturaService;
import com.unab.dogshop.Models.Factura;
//import com.unab.dogshop.Models.Message;
//import com.unab.dogshop.Repositories.CategoriaRepository;

//import com.unab.dogshop.Security.Hash;
//import com.unab.dogshop.Utility.ConvertEntity;
import com.unab.dogshop.Dto.FacturaDto;

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
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.unab.dogshop.Utility.ConvertEntity;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/factura")



public class FacturaController {
    
    @Autowired
    FacturaService facturaService;
    ConvertEntity convertEntity = new ConvertEntity();



    @PostMapping("/create")
    @ResponseBody       
    public Factura save(@RequestBody Factura factura){
        return facturaService.save(factura);
    }

            
    @GetMapping("/list")
    //public ResponseEntity<List<CategoriaDto>>  findAll() {
        public List<FacturaDto>  findAll() {

        List<Factura> facturas = facturaService.findAll();
        List<FacturaDto> facturasDto = new ArrayList<>();
        for (Factura factura : facturas) {
            /*CategoriaDto categoriaDto = new CategoriaDto();
            categoriaDto.setId(categoria.getId());
            categoriaDto.setNombre(categoria.getNombre());
            categoriaDto.setDescripcion(categoria.getDescripcion());
            */
            FacturaDto facturaDto = new FacturaDto();
            facturasDto.add((FacturaDto) convertEntity.convert(factura, facturaDto));
 
            //categoriasDto.add(categoriaDto);
        }
        return facturasDto;
        //return new ResponseEntity<>(categoriasDto, HttpStatus.OK);

    }
}
