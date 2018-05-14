package comrueda.persistance;

import comrueda.entities.SalidaEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class SalidaPersistance {
    private static final Logger LOGGER = Logger.getLogger(MiembroPersistance.class.getName());

    @PersistenceContext(unitName = "ComruedaPU")
    protected EntityManager em;

    public SalidaEntity crear(SalidaEntity entity) {
        LOGGER.info("Creando una salida nueva");
        em.persist(entity);
        LOGGER.info("Nueva salida creada");
        return entity;
    }

    public List<SalidaEntity> listarSalidas(){
        LOGGER.info("Consultando todas las salidas");
        TypedQuery<SalidaEntity> query = em.createQuery("select u from SalidaEntity u", SalidaEntity.class);
        return query.getResultList();
    }

    public SalidaEntity buscar(Long id) {
        return em.find(SalidaEntity.class, id);
    }

    public SalidaEntity actualizar(SalidaEntity entity) {
        return em.merge(entity);
    }

    public void borrar(SalidaEntity entity) {
        em.remove(entity);
    }
}
