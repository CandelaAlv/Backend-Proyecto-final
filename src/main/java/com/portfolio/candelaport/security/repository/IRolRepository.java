
package com.portfolio.candelaport.security.repository;

import com.portfolio.candelaport.security.entity.Rol;
import com.portfolio.candelaport.security.enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Integer>{
    
     Optional<Rol> findByRolNombre(RolNombre rolNombre);
    
}
