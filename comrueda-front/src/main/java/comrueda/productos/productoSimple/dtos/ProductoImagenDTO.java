/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comrueda.productos.productoSimple.dtos;

/**
 *
 * @author jctan
 */
public class ProductoImagenDTO extends ProductoDTO{
    private String imagen;
    
    @Override
    public String getImagen(){
        return this.imagen;
    }
    
    @Override
    public void setImagen(String imagen){
        this.imagen = imagen;
    }
}
