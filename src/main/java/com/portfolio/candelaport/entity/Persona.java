
package com.portfolio.candelaport.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;
import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;




@Entity
public class Persona {
    
    


@Id
@GeneratedValue (strategy= GenerationType.IDENTITY)
private Long id;

@Lob
@NotNull
 @Size(min = 50, max = 5000, message = "no cumple con la longitud")
private String banner;


@NotNull
 @Size(min = 1, max = 40, message = "no cumple con la longitud")
private String titulo;



@NotNull
 @Size(min = 1, max = 40, message = "no cumple con la longitud")
private String name;

@Lob
@NotNull
 @Size(min = 50, max = 5000, message = "no cumple con la longitud")
private String imagen;

@Lob
@NotNull
 @Size(min = 50, max = 5000, message = "no cumple con la longitud")
private String sobreMi;



@NotNull
 @Size(min = 1, max = 400, message = "no cumple con la longitud")
private String email;
    
   
@NotNull
 @Size(min = 1, max = 400, message = "no cumple con la longitud")
private String instagram;

@NotNull
 @Size(min = 1, max = 400, message = "no cumple con la longitud")
private String facebook;

@NotNull
 @Size(min = 1, max = 400, message = "no cumple con la longitud")
private String twitter;


//relacion y para que borre si la persona no existe
    
      //relacion y para que borre si la persona no existe
    @OneToMany(mappedBy="persona", cascade=CascadeType.ALL)
    private List<Proyecto> proyectos; 
    
      //relacion y para que borre si la persona no existe
    @OneToMany(mappedBy="persona", cascade=CascadeType.ALL)
    private List<Habilidad> habilidades; 
    
      //relacion y para que borre si la persona no existe
    @OneToMany(mappedBy="persona", cascade=CascadeType.ALL)
    private List<Estudio> estudios; 
    
      //relacion y para que borre si la persona no existe
    @OneToMany(mappedBy="persona", cascade=CascadeType.ALL)
    private List<Trabajo> trabajos; 


public Persona() {
}

public Persona(String banner, String titulo, String name, String imagen, String sobreMi,
String email, String instagram, String facebook, String twitter) {
this.banner = banner;
this.titulo = titulo;
this.name = name;
this.imagen = imagen;
this.sobreMi = sobreMi;
this.email = email;
this.instagram = instagram;
this.facebook = facebook;
this.twitter = twitter;
}
//le agregue un clave

//---------------------------------------------------------

 @JsonManagedReference
    public List<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(List<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }
    @JsonManagedReference
    public List<Habilidad> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<Habilidad> habilidades) {
        this.habilidades = habilidades;
    }
    
     @JsonManagedReference
    public List<Estudio> getEstudios() {
        return estudios;
    }

    public void setEstudios(List<Estudio> estudios) {
        this.estudios = estudios;
    }
     @JsonManagedReference
    public List<Trabajo> getTrabajos() {
        return trabajos;
    }

    public void setExperiencias(List<Trabajo> trabajos) {
        this.trabajos = trabajos;
    }


//---------------------------------------------------------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getSobreMi() {
        return sobreMi;
    }

    public void setSobreMi(String sobreMi) {
        this.sobreMi = sobreMi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

 }