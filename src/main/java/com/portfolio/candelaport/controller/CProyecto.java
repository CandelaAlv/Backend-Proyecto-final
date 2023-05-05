
package com.portfolio.candelaport.controller;

import com.portfolio.candelaport.entity.Proyecto;
import com.portfolio.candelaport.service.SProyecto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proyecto")
@CrossOrigin(origins = {"http://localhost:4200"})

public class CProyecto {
    
    
      
    @Autowired
SProyecto sProyecto;
    
    
    
    //ver todo
    //
     @GetMapping ("/lista")
   public ResponseEntity<List<Proyecto>> lista(){
        List<Proyecto> list = sProyecto.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
      
     //lista de proyes por id de persona
    @GetMapping ("/persona/{id}/lista")
    public List <Proyecto> listaPer(@PathVariable Long id){
        return sProyecto.findByPersonaId(id);    
        }
    
//ver uno
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyecto> detail(@PathVariable("id") int id){
        Proyecto proye = sProyecto.getOne(id);
        return new ResponseEntity(proye, HttpStatus.OK);
    }


    
@PostMapping("/create")
public String save (@RequestBody Proyecto proye){

sProyecto.save(proye);
return "el proyecto fue creado";
}
   

 
    
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable ("id") int id){
        sProyecto.delete(id);
    }





// ver que onda este
@PutMapping("/editar/{id}")
public Proyecto editarProyecto(@PathVariable int id, @RequestParam("proyecto") String nuevoProyecto,
@RequestParam ("url") String nuevoUrl ) {
Proyecto proye = sProyecto.getOne(id);



proye.setProyecto(nuevoProyecto);

proye.setUrl(nuevoUrl);

sProyecto.save(proye);
return proye;

}


  @PutMapping("/update")
     public void edit(@RequestBody Proyecto proye) {
         sProyecto.edit(proye);
     }






    
    
    
    
    
    
}
