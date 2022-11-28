package com.unab.dogshop.Repositories;

import com.unab.dogshop.Models.Cliente;

import java.util.Optional;

//import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
//import java.util.Optional;

//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;




    @Repository
    public interface ClienteRepository extends CrudRepository<Cliente,String> {
        public Optional<Cliente> findById(String id);
    
        public Cliente findByUserName(String user);
    
        //@Transactional(readOnly = true)
        @Query(value = "Select * from cliente where user_name=:user and clave=:pwd ",nativeQuery = true)
        public Cliente login(@Param("user") String user,@Param("pwd") String pwd);
    
      
    }
    

    //Cliente findByUserName(String user);
    //public Optional<Cliente> findById(String id);

    //Cliente login(String user, String pwd);
    
    
    //public Cliente findByUserName(String valor);
    //public List<Cliente> findByNombreContaining(String valor);
  
    /* 
    @Transactional(readOnly = true)
    @Query(value = "select * from cliente where nombre like %:nombre%",nativeQuery = true)
    public List<Cliente> findByNombrePartialManual(@Param("nombre") String nombre);

    @Transactional(readOnly = true)
    @Query(value = "select * from cliente where email=:email and clave=:clave",nativeQuery = true)
    public Integer logIn(@Param("email") String email,@Param("clave") String clave);
    */

    

    

    
    
