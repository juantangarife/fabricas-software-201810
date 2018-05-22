package comrueda.producto.ejb;

import comrueda.producto.entities.ProductoEntity;

import java.util.List;


public interface ProductoLogic {
    public ProductoEntity crearProducto(ProductoEntity entity);

    public List<ProductoEntity> listarProductos();

    public ProductoEntity buscar(Long id);

    public ProductoEntity actualizar(ProductoEntity entity);

    public void borrar(ProductoEntity entity);

}
