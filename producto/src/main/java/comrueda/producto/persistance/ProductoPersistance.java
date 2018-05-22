package comrueda.producto.persistance;

import comrueda.producto.entities.ProductoEntity;

import java.util.List;
//import javax.ejb.Remote;

public interface ProductoPersistance {

    public ProductoEntity crear(ProductoEntity entity);

    public List<ProductoEntity> listarProductos();

    public ProductoEntity buscar(Long id);

    public ProductoEntity actualizar(ProductoEntity entity);

    public void borrar(ProductoEntity entity);

}
