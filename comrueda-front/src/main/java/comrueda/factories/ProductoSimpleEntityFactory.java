/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comrueda.factories;

import comrueda.dtos.IProductoDTO;
import comrueda.entities.ProductoEntity;

/**
 *
 * @author jctan
 */
public class ProductoSimpleEntityFactory implements IProductoFactoryEntity{

    public ProductoEntity getProductoEntity(IProductoDTO p) {
        ProductoEntity entity = new ProductoEntity();
        entity.setId(p.getId());
        entity.setNombre(p.getNombre());
        entity.setDescripcion(p.getDescripcion());
        entity.setCantidad(p.getCantidad());
        entity.setPrecio(p.getPrecio());
        return entity;
    }
    
}
