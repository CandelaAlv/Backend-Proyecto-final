
package com.portfolio.candelaport.security.service;

import com.portfolio.candelaport.security.entity.Rol;
import com.portfolio.candelaport.security.enums.RolNombre;
import com.portfolio.candelaport.security.repository.IRolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolService {
     @Autowired
    IRolRepository irolRepository;
    //no olvidarme la I mayuscula
    public Optional<Rol> getbyRolNombre(RolNombre rolNombre){
        return irolRepository.findByRolNombre(rolNombre);
    }
    
    public void save(Rol rol){
        irolRepository.save(rol);
    }
}
