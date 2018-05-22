package comrueda.producto.imagen.entities;

import comrueda.producto.entities.ProductoEntity;
import javax.persistence.Entity;
import java.io.Serializable;
import javax.ejb.Stateless;

@Entity(name = "ProductoEntity")
@Stateless(name = "ProductoEntity")
public class ProductoImagenEntity extends BaseEntity implements ProductoEntity, Serializable {

    private static final long serialVersionUID = 7199795167272135570L;

    private String nombre;
    private String descripcion;
    private int cantidad;
    private double precio;

    private String imagen;

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
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
    public int getCantidad() {
        return cantidad;
    }

    @Override
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public double getPrecio() {
        return precio;
    }

    @Override
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getImagen() {
        return this.imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
