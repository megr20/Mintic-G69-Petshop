package com.unab.dogshop.Repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.unab.dogshop.Models.ERol;
import com.unab.dogshop.Models.Role;

@Repository
public interface RolRepository extends CrudRepository<Role,String> {
    public Optional<Role> findByNombre(ERol nombre);
  }

