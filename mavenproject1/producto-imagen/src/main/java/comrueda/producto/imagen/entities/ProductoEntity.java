package comrueda.producto.entities;

import javax.persistence.Entity;
import java.io.Serializable;

public abstract class ProductoEntity extends ProductoBaseEntity implements Serializable {
    private static final long serialVersionUID = 7199795167272135570L;

    private String imagen;

    public String getImagen(){
        return this.imagen;
    }

    public void setImagen(String imagen){
        this.imagen = imagen;
    }
}
