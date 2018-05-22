package comrueda.eventos.encuentros.persistance;



import comrueda.eventos.encuentros.entities.EncuentroEntity;
import comrueda.usuarios.miembros.persistance.MiembroPersistance;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class EncuentroPersistance {
    private static final Logger LOGGER = Logger.getLogger(MiembroPersistance.class.getName());

    @PersistenceContext(unitName = "ComruedaPU")
    protected EntityManager em;

    public EncuentroEntity crear(EncuentroEntity entity) {
        LOGGER.info("Creando una encuentro nuevo");
        em.persist(entity);
        LOGGER.info("Nuevo encuentro creado");
        return entity;
    }

    public List<EncuentroEntity> listarEncuentros(){
        LOGGER.info("Consultando todos los encuentros");
        TypedQuery<EncuentroEntity> query = em.createQuery("select u from EncuentroEntity u", EncuentroEntity.class);
        return query.getResultList();
    }

    public EncuentroEntity buscar(Long id) {
        return em.find(EncuentroEntity.class, id);
    }

    public EncuentroEntity actualizar(EncuentroEntity entity) {
        return em.merge(entity);
    }

    public void borrar(EncuentroEntity entity) {
        em.remove(entity);
    }
}
