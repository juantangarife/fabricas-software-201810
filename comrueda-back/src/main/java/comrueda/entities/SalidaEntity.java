package comrueda.entities;


import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;

@Entity
public class SalidaEntity extends EventoEntity implements Serializable {
    private static final long serialVersionUID = 5141657634228477191L;
    private String puntoEncuentro;
    private String destino;
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
