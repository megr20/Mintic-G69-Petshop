package com.unab.dogshop.Repositories;
//import com.unab.dogshop.Models.Cliente;
import com.unab.dogshop.Models.Item;

import java.util.Optional;

//import java.util.List;
//import java.util.Optional;

//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;

@Repository


public interface ItemRepository extends  CrudRepository<Item,String> {
     //public Optional<Cliente> findById(String id);
    
     public Optional<Item> findById(Item item);
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
 
}
