package comrueda.eventos.encuentros.dtos;


import comrueda.eventos.interfaces.EventoDTO;
import comrueda.eventos.encuentros.entities.EncuentroEntity;

import java.util.Date;

public class EncuentroDTO extends EventoDTO {
    
    private String direccion;
    

    public EncuentroDTO() {
    }

    public EncuentroDTO(EncuentroEntity encuentro) {
        super(encuentro.getId(),encuentro.getNombre(),encuentro.getFecha(),encuentro.getDescripcion());
        direccion=encuentro.getDireccion();
        
    }


    @Override
    public String getPuntoEncuentro() {
        return "";
    }

    @Override
    public void setPuntoEncuentro(String puntoEncuentro) {
        
    }

    @Override
    public String getDestino() {
        return "";
    }

    @Override
    public void setDestino(String destino) {
        
    }

    @Override
    public Date getFechaLlegada() {
        return null;
    }

    @Override
    public void setFechaLlegada(Date fechaLlegada) {
        
    }

    @Override
    public EncuentroEntity toEntity() {
        EncuentroEntity entity = new EncuentroEntity();
        entity.setId(this.id);
        entity.setNombre(this.nombre);
        entity.setFecha(this.fecha);
        entity.setDescripcion(this.descripcion);
        entity.setDireccion(this.direccion);
        return entity;
    }

    @Override
    public String getDireccion() {
        return direccion;
    }

    @Override
    public void setDireccion(String direccion) {
        this.direccion=direccion;
    }
}
