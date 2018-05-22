/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comrueda.productos.productoImagen.dtos;

import comrueda.producto.entities.ProductoEntity;
import comrueda.productos.productoSimple.dtos.ProductoDTO;
import java.lang.reflect.Method;

/**
 *
 * @author jctan
 */
public class ProductoImagenDTO extends ProductoDTO {

    private String imagen;

    public ProductoImagenDTO() {
        super();
    }

    public ProductoImagenDTO(ProductoEntity producto) {
        this.id = producto.getId();
        this.nombre = producto.getNombre();
        this.descripcion = producto.getDescripcion();
        this.cantidad = producto.getCantidad();
        this.precio = producto.getPrecio();
        try {
            Method image = producto.getClass().getMethod("getImagen");
            this.imagen = (String) image.invoke(producto);
        } catch (Exception e) {
            System.out.print("Productos sin imagen.");
        }
    }

    public String getImagen(){
        return this.imagen;
    }
    
    public void setImagen(String imagen){
        this.imagen = imagen;
    }
}
