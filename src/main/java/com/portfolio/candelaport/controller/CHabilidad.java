
package com.portfolio.candelaport.controller;


import com.portfolio.candelaport.entity.Habilidad;
import com.portfolio.candelaport.service.SHabilidad;
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

@RequestMapping("/habilidad")
@CrossOrigin(origins = {"http://localhost:4200"})
public class CHabilidad {

    @Autowired
    SHabilidad sHabilidad;

      
    
    
    
    //ver todo
     @GetMapping ("/lista")
    public ResponseEntity<List<Habilidad>> lista(){
        List<Habilidad> list = sHabilidad.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    
     //lista de habilidad por id de persona
    @GetMapping ("/persona/{id}/lista")
    public List <Habilidad> listaPer(@PathVariable Long id){
        return sHabilidad.findByPersonaId(id);    
        }
    
    //ver uno
      @GetMapping("/detail/{id}")
    public ResponseEntity<Habilidad> detail(@PathVariable("id") int id){
        Habilidad habilidad = sHabilidad.getOne(id);
        return new ResponseEntity(habilidad, HttpStatus.OK);
    }
    
    


    
        @PostMapping("/create")
    public void save(@RequestBody Habilidad habi) {
        sHabilidad.save(habi);
    }
    
    
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable ("id") int id){
        sHabilidad.delete(id);
    }
    
    





// ver si funciona mejor el editar de profe luisina este
@PutMapping("/editar/{id}")
public Habilidad editarHabilidad(@PathVariable int id, @RequestParam("habilidad") String
nuevaHabilidad, @RequestParam("porcentaje") int nuevoPorcentaje ) {
Habilidad habi = sHabilidad.getOne(id);

habi.setHabilidad(nuevaHabilidad);
habi.setPorcentaje(0);

sHabilidad.save(habi);
return habi;

}



//o ver este
@PutMapping("/update")
    public void edit(@RequestBody Habilidad habi) {
        sHabilidad.save(habi);
    }








    
    
    
    
    
}
