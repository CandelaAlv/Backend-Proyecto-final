/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.candelaport.service;

import com.portfolio.candelaport.entity.Trabajo;
import com.portfolio.candelaport.repository.RTrabajo;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional //mantiene la persis
public class STrabajo {

    @Autowired
    RTrabajo rTrabajo;
    
    
   // ver todo
     public List<Trabajo> list(){
        return rTrabajo.findAll();
    }

   // public List<Trabajo> verTrabajo() {
   //     List <Trabajo> listaTrabajo = rTrabajo.findAll();
   //     return rTrabajo.findAll();
  //  }

    //Ver uno
    public Trabajo getOne(int id){
        Trabajo trab = rTrabajo.findById(id).orElse(null);
        return trab;
    }
   
    
    //agregue esto
        public Optional<Trabajo> getByTrabajo(String trabajo){
         return rTrabajo.findByTrabajo(trabajo);
     }
    
    
     public boolean existsById(int id){
         return rTrabajo.existsById(id);
     }
     
     public boolean existsByTrabajo(String trabajo){
         return rTrabajo.existsByTrabajo(trabajo);
     }
    
    
    
    

    public void save(Trabajo trab){
        rTrabajo.save(trab);
    }
    
     public void delete(int id){
        rTrabajo.deleteById(id);
    }
    
    public void edit(Trabajo trab){
        rTrabajo.save(trab);
    }


    
   // public void crearTrabajo(Trabajo trab) {

  //      rTrabajo.save(trab);
 //   }

  //  public void borrarTrabajo(Long id) {
 //       rTrabajo.deleteById(Integer.SIZE);
 //   }

   // public void editarTrabajo(Trabajo trab) {
  //      rTrabajo.save(trab);
   // }

//--------------------------------------------



 //busca lista de trabajo por la id de la persona
    public List<Trabajo> findByPersonaId(Long personaId) {
        return rTrabajo.findByPersonaId(personaId);
    }






//--------------------------------------------

}