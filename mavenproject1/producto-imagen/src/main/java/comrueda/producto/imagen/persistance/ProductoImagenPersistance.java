package comrueda.producto.imagen.persistance;

import comrueda.producto.entities.ProductoEntity;
import comrueda.producto.imagen.entities.ProductoImagenEntity;
import comrueda.producto.persistance.ProductoPersistance;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.logging.Logger;

@Stateless(name="ProductoPersistance")
public class ProductoImagenPersistance implements ProductoPersistance {

    private static final Logger LOGGER = Logger.getLogger(ProductoImagenPersistance.class.getName());

    @PersistenceContext(unitName = "ComruedaPU")
    protected EntityManager em;

    public ProductoEntity crear(ProductoEntity entity) {
        LOGGER.info("Creando un producto nuevo");
        em.persist(entity);
        LOGGER.info("Nuevo producto creado");
        return entity;
    }

    @Override
    public List<ProductoEntity> listarProductos() {
        LOGGER.info("Consultando todas los productos");
        TypedQuery<ProductoEntity> query = em.createQuery("select u from ProductoEntity u", ProductoEntity.class);
        return query.getResultList();
    }

    
    @Override
    public ProductoEntity buscar(Long id) {
        return em.find(ProductoImagenEntity.class, id);
    }
    @Override
    public ProductoEntity actualizar(ProductoEntity entity) {
        return em.merge(entity);
    }

    @Override
    public void borrar(ProductoEntity entity) {
        if (!em.contains(entity)) {
            entity = em.merge(entity);
        }
        em.remove(entity);
    }

}