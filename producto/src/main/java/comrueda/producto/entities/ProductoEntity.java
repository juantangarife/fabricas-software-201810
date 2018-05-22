package comrueda.producto.entities;

public interface ProductoEntity {
    
    public Long getId();

    public void setId(Long id);
    
    public String getNombre();

    public void setNombre(String nombre);

    public String getDescripcion();

    public void setDescripcion(String descripcion);

    public int getCantidad();

    public void setCantidad(int cantidad);

    public double getPrecio();

    public void setPrecio(double precio);
}
