package comrueda.producto.imagen.persistance;

import comrueda.producto.imagen.entities.ProductoImagenEntity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class ProductoImagenPersistance {

    private static final Logger LOGGER = Logger.getLogger(ProductoImagenPersistance.class.getName());

    @PersistenceContext(unitName = "ComruedaPU")
    protected EntityManager em;

    public ProductoImagenEntity crear(ProductoImagenEntity entity) {
        LOGGER.info("Creando un producto nuevo");
        em.persist(entity);
        LOGGER.info("Nuevo producto creado");
        return entity;
    }

    public List<ProductoImagenEntity> listarProductos() {
        LOGGER.info("Consultando todas los productos");
        TypedQuery<ProductoImagenEntity> query = em.createQuery("select u from ProductoEntity u", ProductoImagenEntity.class);
        return query.getResultList();
    }

    public ProductoImagenEntity buscar(Long id) {
        return em.find(ProductoImagenEntity.class, id);
    }

    public ProductoImagenEntity actualizar(ProductoImagenEntity entity) {
        return em.merge(entity);
    }

    public void borrar(ProductoImagenEntity entity) {
        if (!em.contains(entity)) {
            entity = em.merge(entity);
        }
        em.remove(entity);
    }

}
