
package com.portfolio.candelaport.repository;

import com.portfolio.candelaport.entity.Persona;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface IPersona extends JpaRepository<Persona,Long>{
    
   public Optional<Persona> findByName(String name);
    public boolean existsByName(String name);
}
