package comrueda.producto.simple.entities;

import comrueda.producto.entities.ProductoEntity;
import java.io.Serializable;
import javax.ejb.Stateless;
import javax.persistence.Entity;

@Entity(name="ProductoEntity")
@Stateless(name="ProductoEntity")
public class ProductoSimpleEntity extends BaseEntity implements Serializable, ProductoEntity {
    private static final long serialVersionUID = 7199795167272135570L;
    private String nombre;
    private String descripcion;
    private int cantidad;
    private double precio;

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
}
