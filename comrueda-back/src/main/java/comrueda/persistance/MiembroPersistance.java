package comrueda.persistance;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import comrueda.entities.MiembroEntity;

@Stateless
public class MiembroPersistance {

	private static final Logger LOGGER = Logger.getLogger(MiembroPersistance.class.getName());

	@PersistenceContext(unitName = "ComruedaPU")
    protected EntityManager em;

	public MiembroEntity crear(MiembroEntity entity) {
        LOGGER.info("Creando un miembro nuevo");
        em.persist(entity);
        LOGGER.info("Nuevo miembro creado");
        return entity;
    }

    public List<MiembroEntity> listarMiembros(){
        LOGGER.info("Consultando todos los miembros");
        TypedQuery<MiembroEntity> query = em.createQuery("select u from MiembroEntity u", MiembroEntity.class);
        return query.getResultList();
    }

    public MiembroEntity buscarMiembroCorreo(String correo) {
        LOGGER.log(Level.INFO, "Consultando miembro por correo ", correo);

        TypedQuery<MiembroEntity> query = em.createQuery("Select e From MiembroEntity e where e.correo = :correo", MiembroEntity.class);
        query = query.setParameter("correo", correo);
        List<MiembroEntity> results = query.getResultList();
        if (results.isEmpty()) {
            return null;
        } else {
            return results.get(0);
        }
	}

    public MiembroEntity buscar(Long id) {
        return em.find(MiembroEntity.class, id);
    }

    public MiembroEntity actualizar(MiembroEntity entity) {
         return em.merge(entity);
    }

    public void borrar(MiembroEntity entity) {
        em.remove(entity);
    }

}
