package com.unab.dogshop.Exception.Controller;
//import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unab.dogshop.Dto.ClienteDto;
import com.unab.dogshop.Models.Cliente;
import com.unab.dogshop.Exception.Exception.DivisionZeroErrorException;
import com.unab.dogshop.Exception.Exception.NoFoundException;
import com.unab.dogshop.Service.ClienteService;
import com.unab.dogshop.Utility.ConvertEntity;



@RestController
@RequestMapping("/test")
@CrossOrigin("*")
public class TestController {

    @Autowired
    ClienteService clienteService;

    ConvertEntity convertEntity = new ConvertEntity();

    @GetMapping("/operacion/{num1}/{num2}")
    public double operarcion(@PathVariable double num1, @PathVariable double num2, @RequestBody String operacion) {

        if (num2 == 0) {
            throw new DivisionZeroErrorException("Numerador en 0");
        }
        return num1 / num2;
    }

    @GetMapping("/usuario/{username}")
    public ClienteDto operarcion(@PathVariable String username) {
        Cliente cliente = clienteService.findByUserName(username);

        if(cliente==null){
            throw new NoFoundException("El usuario con UserName "+username+" no existe");
        }

        return (ClienteDto) convertEntity.convert(cliente, new ClienteDto());

    }
}

