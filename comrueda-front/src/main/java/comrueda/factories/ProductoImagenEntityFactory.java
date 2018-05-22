/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comrueda.factories;

import comrueda.common.helpers.LookupHelper;
import comrueda.producto.entities.ProductoEntity;
import comrueda.productos.productoImagen.dtos.ProductoImagenDTO;
import java.lang.reflect.Method;

/**
 *
 * @author jctan
 */
public class ProductoImagenEntityFactory{
    public ProductoImagenEntityFactory(){
        
    }
    public ProductoEntity getProductoEntity(ProductoImagenDTO p) {
        ProductoEntity entity = LookupHelper.lookup(ProductoEntity.class);
        entity.setId(p.getId());
        entity.setNombre(p.getNombre());
        entity.setDescripcion(p.getDescripcion());
        entity.setCantidad(p.getCantidad());
        entity.setPrecio(p.getPrecio());
        try {
            Method image = entity.getClass().getMethod("setImagen", new Class[]{String.class});
            image.invoke(entity, p.getImagen());
        } catch (Exception e) {
            System.out.print("Productos sin imagen.");
        }
        return entity;
    }
}
