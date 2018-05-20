/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comrueda.factories;

import comrueda.productos.productoSimple.entities.ProductoEntity;
import comrueda.productos.dtos.interfaces.IProductoDTO;
/**
 *
 * @author jctan
 */
public interface IProductoFactoryEntity {
    public ProductoEntity getProductoEntity(IProductoDTO p);
}
