package comrueda.producto.ejb;

import comrueda.producto.entities.ProductoEntity;
import comrueda.producto.persistance.ProductoPersistance;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
//import javax.ejb.Remote;

//@Remote(ProductoLogic.class)
//public interface ProductoLogic {
//    public ProductoEntity crearProducto(ProductoEntity entity);
//
//    public List<ProductoEntity> listarProductos();
//
//    public ProductoEntity buscar(Long id);
//
//    public ProductoEntity actualizar(ProductoEntity entity);
//
//    public void borrar(ProductoEntity entity);
//
//}

@Stateless(name="ProductoLogic")
public class ProductoLogic {

    private static final Logger LOGGER = Logger.getLogger(ProductoLogic.class.getName());

    @Inject
    private ProductoPersistance persistence;

    public ProductoEntity crearProducto(ProductoEntity entity) {
        LOGGER.info("Inicia proceso de creación de producto");
        persistence.crear(entity);
        LOGGER.info("Termina proceso de creación de producto");
        return entity;
    }

    public List<ProductoEntity> listarProductos() {
        LOGGER.info("Inicia proceso de consultar todos los productos");
        List<ProductoEntity> productos = persistence.listarProductos();
        LOGGER.info("Termina proceso de consultar todos los productos");
        return productos;
    }

    public ProductoEntity buscar(Long id) {
        return persistence.buscar(id);
    }

    public ProductoEntity actualizar(ProductoEntity entity) {
        return persistence.actualizar(entity);
    }


    public void borrar(ProductoEntity entity) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar producto con id={0}", entity.getId());
        persistence.borrar(entity);
        LOGGER.log(Level.INFO, "Termina proceso de borrar productoo con id={0}", entity.getId());
    }

}
