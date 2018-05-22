package comrueda.eventos.salidas.entities;


import comrueda.eventos.entities.EventoEntity;
import comrueda.common.podam.DateStrategy;
import uk.co.jemos.podam.common.PodamStrategyValue;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Entity
public class SalidaEntity extends EventoEntity implements Serializable {
    private static final long serialVersionUID = 5141657634228477192L;
    private String puntoEncuentro;
    private String destino;
    
    @Temporal(TemporalType.DATE)
    @PodamStrategyValue(DateStrategy.class)
    private Date fechaLlegada;

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
}
