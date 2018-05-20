package comrueda.eventos.salidas.dtos;

import comrueda.eventos.salidas.entities.SalidaEntity;

import java.util.Date;

public class SalidaDTO {
    private Long id;
    private String nombre;
    private Date fecha;
    private String descripcion;
    private String puntoEncuentro;
    private String destino;
    private Date fechaLlegada;

    public SalidaDTO() {
    }

    public SalidaDTO(SalidaEntity salida) {
        this.id = salida.getId();
        this.nombre = salida.getNombre();
        this.fecha = salida.getFecha();
        this.descripcion = salida.getDescripcion();
        this.puntoEncuentro = salida.getPuntoEncuentro();
        this.destino = salida.getDestino();
        this.fechaLlegada = salida.getFechaLlegada();
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

    public String getPuntoEncuentro() {
        return puntoEncuentro;
    }

    public void setPuntoEncuentro(String puntoEncuentro) {
        this.puntoEncuentro = puntoEncuentro;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

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
}
