package comrueda.producto.ejb;

import comrueda.producto.entities.ProductoEntity;
import comrueda.producto.persistance.ProductoPersistance;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless(name = "ProductoLogic")
public class ProductoImagenLogic implements ProductoLogic {

    private static final Logger LOGGER = Logger.getLogger(ProductoImagenLogic.class.getName());

    @Inject
    private ProductoPersistance persistence;

    @Override
    public ProductoEntity crearProducto(ProductoEntity entity) {
        LOGGER.info("Inicia proceso de creación de producto");
        persistence.crear(entity);
        LOGGER.info("Termina proceso de creación de producto");
        return entity;
    }

    @Override
    public List<ProductoEntity> listarProductos() {
        LOGGER.info("Inicia proceso de consultar todos los productos");
        List<ProductoEntity> productos = persistence.listarProductos();
        LOGGER.info("Termina proceso de consultar todos los productos");
        return productos;
    }

    @Override
    public ProductoEntity buscar(Long id) {
        return persistence.buscar(id);
    }

    @Override
    public ProductoEntity actualizar(ProductoEntity entity) {
        return persistence.actualizar(entity);
    }

    @Override
    public void borrar(ProductoEntity entity) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar producto con id={0}", entity.getId());
        persistence.borrar(entity);
        LOGGER.log(Level.INFO, "Termina proceso de borrar productoo con id={0}", entity.getId());
    }

}
