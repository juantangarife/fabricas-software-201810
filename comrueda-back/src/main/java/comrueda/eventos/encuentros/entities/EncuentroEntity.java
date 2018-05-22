package comrueda.eventos.encuentros.entities;


import comrueda.eventos.entities.EventoEntity;
import comrueda.common.podam.DateStrategy;
import uk.co.jemos.podam.common.PodamStrategyValue;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class EncuentroEntity extends EventoEntity implements Serializable {
    private static final long serialVersionUID = 5141657634228477191L;
    
    private String direccion;
    
   
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
