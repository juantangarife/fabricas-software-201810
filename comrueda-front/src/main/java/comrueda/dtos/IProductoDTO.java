/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comrueda.dtos;

/**
 *
 * @author jctan
 */
public interface IProductoDTO {
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
    
    public void setImagen(String imagen);
    
    public String getImagen();
}
