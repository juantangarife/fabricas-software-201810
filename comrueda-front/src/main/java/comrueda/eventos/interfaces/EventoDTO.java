/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comrueda.eventos.interfaces;

import comrueda.eventos.entities.EventoEntity;
import java.util.Date;

/**
 *
 * @author Sistemas
 */
public abstract class EventoDTO {
    protected Long id;
    protected String nombre;
    protected Date fecha;
    protected String descripcion;

    
    public EventoDTO(){
        
    }

    public EventoDTO(Long id, String nombre, Date fecha, String descripcion){
        this.id=id;
        this.nombre=nombre;
        this.fecha=fecha;
        this.descripcion=descripcion;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public abstract String getPuntoEncuentro();

    public abstract void setPuntoEncuentro(String puntoEncuentro);

    public abstract String getDestino();

    public abstract void setDestino(String destino);

    public abstract Date getFechaLlegada();

    public abstract void setFechaLlegada(Date fechaLlegada);

    public abstract EventoEntity toEntity();
    
    public abstract String getDireccion();
    
    public abstract void setDireccion(String direccion);
}
