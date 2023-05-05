
package com.portfolio.candelaport.service;


import com.portfolio.candelaport.entity.Estudio;
import com.portfolio.candelaport.repository.REstudio;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SEstudio {
@Autowired

REstudio rEstudio;

//muchos estudios
  public List<Estudio> list(){
        return rEstudio.findAll();
    }



  //un estudio
      public Estudio getOne(int id){
        Estudio estu = rEstudio.findById(id).orElse(null);
        return estu;
    }
  
  
  
    public Optional<Estudio> getByEstudio(String estudio){
        return rEstudio.findByEstudio(estudio);
    }

//Parece este pero a este le acepta el id sin integer SIZE
  //public Estudio getOne(int id){
       // Estudio estu = rEstudio.findById(id).orElse(null);
       // return estu;
   // }



      
      
   public void save(Estudio estu){
        rEstudio.save(estu);
    }     
      
      
     public void delete(int id){
        rEstudio.deleteById(id);
    }
    
    public void edit(Estudio estu){
        rEstudio.save(estu);
    }
   
    
     public boolean existsById(int id){
        return rEstudio.existsById(id);
    }
    
   public boolean existsByEstudio(String estudio){
         return rEstudio.existsByEstudio(estudio);
     }
    
   
//public void crearEstudio(Estudio estu) {

//rEstudio.save(estu);
//}

//public void borrarEstudio(Long id) {
//rEstudio.deleteById(Integer.SIZE);
//}

//public void editarEstudio(Estudio estu){
//rEstudio.save(estu);
//}


 //busca lista de estudios por la id de la persona
    public List<Estudio> findByPersonaId(Long personaId) {
        return rEstudio.findByPersonaId(personaId);
    }
//--------------------------------------------


}