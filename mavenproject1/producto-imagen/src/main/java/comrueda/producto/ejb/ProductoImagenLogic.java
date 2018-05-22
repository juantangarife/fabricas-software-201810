package comrueda.producto.ejb;

import comrueda.producto.imagen.entities.ProductoImagenEntity;
import comrueda.producto.imagen.persistance.ProductoImagenPersistance;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless(name="ProductoLogic")
public class ProductoImagenLogic {

    private static final Logger LOGGER = Logger.getLogger(ProductoImagenLogic.class.getName());

    @Inject
    private ProductoImagenPersistance persistence;

    public ProductoImagenEntity crearProducto(ProductoImagenEntity entity) {
        LOGGER.info("Inicia proceso de creación de producto");
        persistence.crear(entity);
        LOGGER.info("Termina proceso de creación de producto");
        return entity;
    }

    public List<ProductoImagenEntity> listarProductos() {
        LOGGER.info("Inicia proceso de consultar todos los productos");
        List<ProductoImagenEntity> productos = persistence.listarProductos();
        LOGGER.info("Termina proceso de consultar todos los productos");
        return productos;
    }

    public ProductoImagenEntity buscar(Long id) {
        return persistence.buscar(id);
    }

    public ProductoImagenEntity actualizar(ProductoImagenEntity entity) {
        return persistence.actualizar(entity);
    }

    public void borrar(ProductoImagenEntity entity) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar producto con id={0}", entity.getId());
        persistence.borrar(entity);
        LOGGER.log(Level.INFO, "Termina proceso de borrar productoo con id={0}", entity.getId());
    }

}
