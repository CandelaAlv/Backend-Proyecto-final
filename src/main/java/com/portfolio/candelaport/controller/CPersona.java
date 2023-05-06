
package com.portfolio.candelaport.controller;


import com.portfolio.candelaport.entity.Persona;
import com.portfolio.candelaport.security.controller.Mensaje;
import com.portfolio.candelaport.service.SPersona;
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


import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persona")
// tenia esto el cross("*")
@CrossOrigin(origins={"https://porttfolio-frontend.web.app/","http://localhost:4200"})

public class CPersona {

@Autowired
SPersona persoServ;


    
//una persona

     @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> detail(@PathVariable("id") Long id){
        Persona per = persoServ.getOne(id);
        return new ResponseEntity(per, HttpStatus.OK);
    }       
    
    //para ver todas las personas
       @GetMapping ("/lista")
    public ResponseEntity<List<Persona>> list(){
        List<Persona> list = persoServ.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    



@PostMapping("/create")
public String agregarPersona (@RequestBody Persona per){

persoServ.save(per);
return "la persona fue creada";
}
// ver por qué usa un void el


@DeleteMapping ("/delete/{id}")
public String borrarPersona(@PathVariable Long id){
persoServ.delete(id);
return "la persona fue borrada";
}

  
    @PutMapping("/update")
    public void edit(@RequestBody Persona persona){
        persoServ.edit(persona);
    }
        

//ver este que onda

@PutMapping("/editar/{id}")
public Persona editPersona(@PathVariable Long id, @RequestParam("banner") String
nuevoBanner, @RequestParam("titulo") String nuevoTitulo, @RequestParam("name") String
nuevoName,
@RequestParam ("imagen") String nuevaImagen, @RequestParam ("sobreMi") String
nuevoSobreMi, @RequestParam ("email") String nuevoEmail,
@RequestParam ("instagram") String nuevoInstagram, @RequestParam ("facebook")
String nuevoFacebook, @RequestParam ("twitter") String nuevoTwitter) {
Persona per = persoServ.getOne(id);
//ojo aca en findPersona iba buscarPersona
per.setBanner(nuevoBanner);
per.setTitulo(nuevoTitulo);
per.setName(nuevoName);
per.setImagen (nuevaImagen);
per.setSobreMi(nuevoSobreMi);
per.setEmail(nuevoEmail);
per.setInstagram(nuevoInstagram);
per.setFacebook(nuevoFacebook);
per.setTwitter(nuevoTwitter);
persoServ.save(per);
return per;

}




}