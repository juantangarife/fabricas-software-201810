package comrueda.usuarios.miembros.entities;

import comrueda.usuarios.entities.UsuarioEntity;
import comrueda.common.podam.DateStrategy;
import uk.co.jemos.podam.common.PodamStrategyValue;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Entity
public class MiembroEntity extends UsuarioEntity implements Serializable {

    private static final long serialVersionUID = 8447500785941603422L;
    
    @Temporal(TemporalType.DATE)
    @PodamStrategyValue(DateStrategy.class)
    private Date fechaNacimiento;
    
    private boolean esAdministrador;

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public boolean getEsAdministrador() {
        return esAdministrador;
    }

    public void setEsAdministrador(boolean esAdministrador) {
        this.esAdministrador = esAdministrador;
    }
}
