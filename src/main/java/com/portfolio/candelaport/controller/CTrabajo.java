
package com.portfolio.candelaport.controller;

import com.portfolio.candelaport.entity.Trabajo;
import com.portfolio.candelaport.security.controller.Mensaje;
import com.portfolio.candelaport.service.STrabajo;
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
@RequestMapping("/trabajo")
@CrossOrigin(origins = {"http://localhost:4200"})


public class CTrabajo {
  
    
@Autowired
STrabajo sTrabajo;


//ver todos
 @GetMapping ("/lista")
    public ResponseEntity<List<Trabajo>> lista(){
        List<Trabajo> list = sTrabajo.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }



 //lista de trabajos por id de persona
    @GetMapping ("/persona/{id}/lista")
    public List <Trabajo> listaPer(@PathVariable Long id){
        return sTrabajo.findByPersonaId(id);    
        }

@GetMapping("/detail/{id}")
    public ResponseEntity<Trabajo> detail(@PathVariable("id") int id){
        Trabajo trab = sTrabajo.getOne(id);
        return new ResponseEntity(trab, HttpStatus.OK);
    }


   
   
    
    
    
    
    
    @PostMapping("/create")
    public void save(@RequestBody Trabajo trab) {      
        sTrabajo.save(trab);
    }
    
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable ("id") int id){
        sTrabajo.delete(id);
    }




// ver que onda este
@PutMapping("/editar/{id}")
public Trabajo editarTrabajo(@PathVariable int id, @RequestParam("trabajo") String
nuevoTrabajo, @RequestParam("fecha") String
nuevaFecha,
@RequestParam ("descripcion") String nuevaDescripcion ) {
Trabajo trab = sTrabajo.getOne(id);

trab.setTrabajo(nuevoTrabajo);
trab.setFecha(nuevaFecha);
trab.setDescripcion(nuevaDescripcion);

sTrabajo.save(trab);
return trab;

}


//probar update
 @PutMapping("/update")
    public void edit(@RequestBody Trabajo trab) {      
        sTrabajo.save(trab);
    }














}
