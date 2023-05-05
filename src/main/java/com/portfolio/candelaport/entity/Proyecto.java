
package com.portfolio.candelaport.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
public class Proyecto {
    
    @Id
@GeneratedValue (strategy= GenerationType.IDENTITY)
private int id;
    

    @NotNull
    @Size(min = 1, max = 45, message = "no cumple con la longitud")
    private String proyecto;
  
    
    @Size(min = 1, max = 500, message = "no cumple con la longitud")
    private String url;
    
    
    
    //--------------------------------------------
     //relacion
    @ManyToOne
    //creacion de columna con llave foranea
    @JoinColumn(name = "personaid", insertable=false, updatable=false)
    //para que se borre si se borra la persona
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Persona persona;
    
    private Long personaid;

    //--------------------------------------------
    
    
    
    
    public Proyecto() {
    }

    public Proyecto( String proyecto, String url, Persona persona) {
        
        this.proyecto = proyecto;
       
        this.url = url;
        this.persona = persona;
    }

    //Ver si es necesario borrar getter setter y ponerlos manualmente
     //Opción para que no haga un bug
    @JsonBackReference
    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Long getPersonaid() {
        return personaid;
    }

    public void setPersonaid(Long personaid) {
        this.personaid = personaid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProyecto() {
        return proyecto;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    

    
    
    
    
    
    
}
