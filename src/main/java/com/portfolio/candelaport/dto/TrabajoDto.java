
package com.portfolio.candelaport.dto;

import javax.validation.constraints.NotBlank;


public class TrabajoDto {
    @NotBlank
    private String trabajo;
    @NotBlank
    private String fecha;
    @NotBlank
    private String descripcion;

    public TrabajoDto(String trabajo, String fecha, String descripcion) {
        this.trabajo = trabajo;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    public TrabajoDto() {
    }

    public String getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(String trabajo) {
        this.trabajo = trabajo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
    
    
}
