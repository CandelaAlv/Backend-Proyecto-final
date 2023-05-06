
package com.portfolio.candelaport.controller;

import com.portfolio.candelaport.entity.Estudio;
import com.portfolio.candelaport.service.SEstudio;
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
@RequestMapping("/estudio")
@CrossOrigin(origins={"https://porttfolio-frontend.web.app/","http://localhost:4200"})
public class CEstudio {

@Autowired
SEstudio sEstudio;







// ver todo
    @GetMapping ("/lista")
    public ResponseEntity<List<Estudio>> list(){
        List<Estudio> list = sEstudio.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }



  //lista de estudios por id de persona
    @GetMapping ("/persona/{id}/lista")
    public List <Estudio> listaPer(@PathVariable Long id){
        return sEstudio.findByPersonaId(id);    
        }



    //ver UNO
      @GetMapping("/detail/{id}")
    public ResponseEntity<Estudio> detail(@PathVariable("id") int id){
        Estudio estu = sEstudio.getOne(id);
        return new ResponseEntity(estu, HttpStatus.OK);
    }
    
    


@PostMapping("/create")
    public void save(@RequestBody Estudio estu) {      
        sEstudio.save(estu);
    }


   
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable ("id") int id){
        sEstudio.delete(id);
    }





//ver este de abajo

@PutMapping("/editar/{id}")
public Estudio editarEstudio(@PathVariable int id, @RequestParam("estudio") String
nuevoEstudio, @RequestParam("fecha") String
nuevaFecha,
@RequestParam ("descripcion") String nuevaDescripcion ) {
Estudio estu = sEstudio.getOne(id);

estu.setEstudio(nuevoEstudio);
estu.setFecha(nuevaFecha);
estu.setDescripcion(nuevaDescripcion);

sEstudio.save(estu);
return estu;

}

// deberia ser asi:

 @PutMapping("/update")
    public void edit(@RequestBody Estudio estu) {      
        sEstudio.save(estu);
    }









}