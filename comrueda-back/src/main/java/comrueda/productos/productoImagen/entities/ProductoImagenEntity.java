package comrueda.productos.productoImagen.entities;

import comrueda.productos.entities.ProductoBaseEntity;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class ProductoImagenEntity extends ProductoBaseEntity implements Serializable {
    private static final long serialVersionUID = 7199795167272135570L;

    private String imagen;

    public String getImagen(){
        return this.imagen;
    }

    public void setImagen(String imagen){
        this.imagen = imagen;
    }
}
