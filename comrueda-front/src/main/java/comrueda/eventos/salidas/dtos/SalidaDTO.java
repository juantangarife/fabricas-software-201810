package comrueda.eventos.salidas.dtos;

import comrueda.eventos.interfaces.EventoDTO;
import comrueda.eventos.salidas.entities.SalidaEntity;

import java.util.Date;

public class SalidaDTO extends EventoDTO {
    
    private String puntoEncuentro;
    private String destino;
    private Date fechaLlegada;

    public SalidaDTO() {
    }

    public SalidaDTO(SalidaEntity salida) {
        super(salida.getId(),salida.getNombre(),salida.getFecha(),salida.getDescripcion());
        this.puntoEncuentro = salida.getPuntoEncuentro();
        this.destino = salida.getDestino();
        this.fechaLlegada = salida.getFechaLlegada();
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public Date getFecha() {
        return fecha;
    }

    @Override
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String getPuntoEncuentro() {
        return puntoEncuentro;
    }

    @Override
    public void setPuntoEncuentro(String puntoEncuentro) {
        this.puntoEncuentro = puntoEncuentro;
    }

    @Override
    public String getDestino() {
        return destino;
    }

    @Override
    public void setDestino(String destino) {
        this.destino = destino;
    }

    @Override
    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    @Override
    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    @Override
    public SalidaEntity toEntity() {
        SalidaEntity entity = new SalidaEntity();
        entity.setId(this.id);
        entity.setNombre(this.nombre);
        entity.setFecha(this.fecha);
        entity.setDescripcion(this.descripcion);
        entity.setPuntoEncuentro(this.puntoEncuentro);
        entity.setDestino(this.destino);
        entity.setFechaLlegada(this.fechaLlegada);
        return entity;
    }

    @Override
    public String getDireccion() {
        throw new UnsupportedOperationException("No disponible");
    }

    @Override
    public void setDireccion(String encuentro) {
        throw new UnsupportedOperationException("No disponible");
    }
}
