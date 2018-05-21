/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comrueda.productos.productoImagen.dtos;

import comrueda.productos.productoImagen.entities.ProductoImagenEntity;
import comrueda.productos.productoSimple.dtos.ProductoDTO;

/**
 *
 * @author jctan
 */
public class ProductoImagenDTO extends ProductoDTO {

    private String imagen;

    public ProductoImagenDTO() {
        super();
    }

    public ProductoImagenDTO(ProductoImagenEntity producto) {
        this.id = producto.getId();
        this.nombre = producto.getNombre();
        this.descripcion = producto.getDescripcion();
        this.cantidad = producto.getCantidad();
        this.precio = producto.getPrecio();
        this.imagen = producto.getImagen();
    }

    public String getImagen(){
        return this.imagen;
    }
    
    public void setImagen(String imagen){
        this.imagen = imagen;
    }
}
