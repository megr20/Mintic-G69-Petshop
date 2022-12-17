package com.unab.dogshop.Controller;

import com.unab.dogshop.Service.ItemService;
import com.unab.dogshop.Models.Item;
//import com.unab.dogshop.Models.Message;
//import com.unab.dogshop.Repositories.CategoriaRepository;

//import com.unab.dogshop.Security.Hash;
//import com.unab.dogshop.Utility.ConvertEntity;
import com.unab.dogshop.Dto.ItemDto;

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
@RequestMapping("/api/v1/item")



public class ItemController {
    
    @Autowired
    ItemService itemService;
    ConvertEntity convertEntity = new ConvertEntity();



    @PostMapping("/create")
    @ResponseBody       
    public Item save(@RequestBody Item item){
        return itemService.save(item);
    }

            
    @GetMapping("/list")
    //public ResponseEntity<List<CategoriaDto>>  findAll() {
        public List<ItemDto>  findAll() {

        List<Item> items = itemService.findAll();
        List<ItemDto> itemsDto = new ArrayList<>();
        for (Item item : items) {
            /*CategoriaDto categoriaDto = new CategoriaDto();
            categoriaDto.setId(categoria.getId());
            categoriaDto.setNombre(categoria.getNombre());
            categoriaDto.setDescripcion(categoria.getDescripcion());
            */
            ItemDto itemDto = new ItemDto();
            itemsDto.add((ItemDto) convertEntity.convert(item, itemDto));
 
            //categoriasDto.add(categoriaDto);
        }
        return itemsDto;
        //return new ResponseEntity<>(categoriasDto, HttpStatus.OK);

    }
}
