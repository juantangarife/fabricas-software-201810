package comrueda.productos.productoSimple.persistance;

import comrueda.productos.productoSimple.entities.ProductoEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class ProductoPersistance {
	
	private static final Logger LOGGER = Logger.getLogger(ProductoPersistance.class.getName());
	
	@PersistenceContext(unitName = "ComruedaPU")
    protected EntityManager em;
	
	public ProductoEntity crear(ProductoEntity entity) {
        LOGGER.info("Creando un producto nuevo");
        em.persist(entity);
        LOGGER.info("Nuevo producto creado");
        return entity;
    }

    public List<ProductoEntity> listarProductos(){
        LOGGER.info("Consultando todas los productos");
        TypedQuery<ProductoEntity> query = em.createQuery("select u from ProductoEntity u", ProductoEntity.class);
        return query.getResultList();
    }

    public ProductoEntity buscar(Long id) {
        return em.find(ProductoEntity.class, id);
    }

    public ProductoEntity actualizar(ProductoEntity entity) {
         return em.merge(entity);
    }
    
    public void borrar(ProductoEntity entity) {
        em.remove(entity);
    }

}
