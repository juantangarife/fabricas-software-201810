/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comrueda.factories;

import comrueda.productos.dtos.IProductoDTO;
import comrueda.productos.productoSimple.dtos.ProductoDTO;
import comrueda.productos.productoSimple.entities.ProductoEntity;

/**
 *
 * @author jctan
 */
public class ProductoSimpleEntityFactory{
    public ProductoSimpleEntityFactory(){
        
    }
    public ProductoEntity getProductoEntity(ProductoDTO p) {
        ProductoEntity entity = new ProductoEntity();
        entity.setId(p.getId());
        entity.setNombre(p.getNombre());
        entity.setDescripcion(p.getDescripcion());
        entity.setCantidad(p.getCantidad());
        entity.setPrecio(p.getPrecio());
        return entity;
    }
    
}
