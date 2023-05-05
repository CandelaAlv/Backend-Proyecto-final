
package com.portfolio.candelaport.repository;
import com.portfolio.candelaport.entity.Habilidad;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RHabilidad extends JpaRepository<Habilidad, Integer>{
    
      //toma la lista de los relojes por persona
    List<Habilidad> findByPersonaId(Long personaId);
}