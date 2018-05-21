/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comrueda.productos.dtos;

/**
 *
 * @author jctan
 */
public interface IProductoDTO {
    Long getId();

    void setId(Long id);

    String getNombre();

    void setNombre(String nombre);

    String getDescripcion();

    void setDescripcion(String descripcion);

    int getCantidad();

    void setCantidad(int cantidad);

    double getPrecio();

    void setPrecio(double precio);
}
