package comrueda.productos.entities;

import comrueda.common.entities.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public abstract class ProductoBaseEntity extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 7199795167272135570L;
    private String nombre;
    private String descripcion;
    private int cantidad;
    private double precio;

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
}
