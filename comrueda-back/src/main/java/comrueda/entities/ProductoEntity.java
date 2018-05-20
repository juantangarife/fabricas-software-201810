package comrueda.entities;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class ProductoEntity extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 7199795167272135570L;
    private String nombre;
    private String descripcion;
    private int cantidad;
    private double precio;
    private String imagen;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    public String getImagen(){
        return this.imagen;
    }
    
    public void setImagen(String imagen){
        this.imagen = imagen;
    }
}
