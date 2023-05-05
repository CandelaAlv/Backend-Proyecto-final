
package com.portfolio.candelaport.service;

import com.portfolio.candelaport.entity.Proyecto;
import com.portfolio.candelaport.repository.RProyecto;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional//persistencia en base de datos
public class SProyecto {
    
    
      @Autowired
    RProyecto rProyecto;
    
      
      
      //--------------------------------------------
      //traer todo
     public List<Proyecto> list(){
        return rProyecto.findAll();
     }

      
        
    //traer uno
      public Proyecto getOne(int id){
        Proyecto proye = rProyecto.findById(id).orElse(null);
        return proye;
    }  
      
      
      
    //--------------------------------------------
    //busca lista de relojes por la id de la persona
    public List<Proyecto> findByPersonaId(Long personaId) {
        return rProyecto.findByPersonaId(personaId);
    }
    
    //--------------------------------------------
    
    
    
       public void save(Proyecto proye){
        rProyecto.save(proye);
    }
    
     public void delete(int id){
        rProyecto.deleteById(id);
    }
     
     public void edit(Proyecto proye){
        rProyecto.save(proye);
    }
    
    
    
    
    
    
    
    
    
    
    
    
   //  public List<Proyecto> verProyecto() {
   //     List <Proyecto> listaProyecto = rProyecto.findAll();
   //     return rProyecto.findAll();
   // }
    //--------------------------------------------
    
   
       
   // public Proyecto buscarProyecto(Long id) {
   //     Proyecto proye = rProyecto.findById(Integer.SIZE).orElse(null);
   //     return proye;
  //  }
     
     //--------------------------------------------
     
     
     
     
     
     
     
     
     
     
   //   public void crearProyecto(Proyecto proye) {

   //     rProyecto.save(proye);
  //  }

    
      
 //   public void borrarProyecto(Long id) {
  //      rProyecto.deleteById(Integer.SIZE);
   // }

  //  public void editarProyecto(Proyecto proye) {
   //     rProyecto.save(proye);
  //  }
    
    
    
    
    
  
    
    
    
    
}
