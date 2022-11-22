package com.unab.dogshop;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DogshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(DogshopApplication.class, args);
	}

	/*@Bean instalar
	/public new ModelMapper */ 

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

}
