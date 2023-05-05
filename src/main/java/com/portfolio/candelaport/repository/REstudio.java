
package com.portfolio.candelaport.repository;


import com.portfolio.candelaport.entity.Estudio;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface REstudio extends JpaRepository<Estudio,Integer>{
    
    
     public Optional<Estudio> findByEstudio(String estudio);
    public boolean existsByEstudio(String estudio);
    
    
  //toma la lista de los relojes por persona
    List<Estudio> findByPersonaId(Long personaId);
}