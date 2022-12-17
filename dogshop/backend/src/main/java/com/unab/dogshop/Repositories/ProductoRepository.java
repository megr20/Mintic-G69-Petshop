package com.unab.dogshop.Repositories;
import com.unab.dogshop.Models.Producto;
import com.unab.dogshop.Models.Categoria;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;

//import java.util.List;
//import java.util.Optional;

//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Transactional;

@Repository


public interface ProductoRepository extends  CrudRepository<Producto,String> {
     //public Optional<Cliente> findById(String id);
          
    //public Producto findById(Producto producto);
     //public Optional<Producto> findByIdCategoria(Producto producto);
    public List<Producto> findByCategoria(Categoria categoria);
    public Optional<Producto> findById(String id);
    //public List<Producto> findById(Producto producto);

   /*  @Query(value = "Select * from producto where id=:id ",nativeQuery = true)
    public Producto login(@Param("user") String user,@Param("pwd") String pwd);*/
    /* / @Transactional(readOnly = true)
     @Query(value = "select * from producto where id_categoria = id_categoria",nativeQuery = true)
     public List<Producto> findById_Categoria(@Param("id_categoria") String id_categoria);
     */
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
 /*Select * from producto where id= categoria buscada */
}
