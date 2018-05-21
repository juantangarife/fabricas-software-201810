/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comrueda.factories;


import comrueda.productos.productoImagen.dtos.ProductoImagenDTO;
import comrueda.productos.productoImagen.entities.ProductoImagenEntity;

/**
 *
 * @author jctan
 */
public class ProductoImagenEntityFactory{
    public ProductoImagenEntityFactory(){
        
    }
    public ProductoImagenEntity getProductoEntity(ProductoImagenDTO p) {
        ProductoImagenEntity entity = new ProductoImagenEntity();
        entity.setId(p.getId());
        entity.setNombre(p.getNombre());
        entity.setDescripcion(p.getDescripcion());
        entity.setCantidad(p.getCantidad());
        entity.setPrecio(p.getPrecio());
        entity.setImagen(p.getImagen());
        return entity;
    }
    
}
