package comrueda.entities;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;

@Entity
public class MiembroEntity extends UsuarioEntity implements Serializable {
    private static final long serialVersionUID = 8447500785941603422L;
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
