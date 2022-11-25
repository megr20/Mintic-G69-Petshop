package com.unab.dogshop.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;

import com.unab.dogshop.Models.Item;
//import com.unab.dogshop.Models.Message;
import com.unab.dogshop.Repositories.ItemRepository;
//import com.unab.dogshop.Security.Hash;
//import com.unab.dogshop.Utility.ConvertEntity;

//import scala.collection.mutable.ListBuffer;


import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;






@Service
@Transactional


public class ItemService {
 
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ItemRepository itemRepository;

    

    public List<Item> findAll() {
        return (List<Item>) itemRepository.findAll();
    }


    public Optional<Item> findByNombre(Item item) {
        return itemRepository.findByNombre(item);
    }

    public Item save(Item item){
        return itemRepository.save(item);
    }

}




  




