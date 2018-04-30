package comrueda.persistance;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import comrueda.entities.UsuarioEntity;

@Stateless
public class UsuarioPersistance {
	
	private static final Logger LOGGER = Logger.getLogger(UsuarioPersistance.class.getName());
	
	@PersistenceContext(unitName = "ComruedaPU")
    protected EntityManager em;
	
	public UsuarioEntity crear(UsuarioEntity entity) {
        LOGGER.info("Creando un usuario nueva");
        em.persist(entity);
        LOGGER.info("Nuevo usuario creada");
        return entity;
    }
	
	public UsuarioEntity buscarUsuarioNombre(String nombre) {
        LOGGER.log(Level.INFO, "Consultando usuario por nombre ", nombre);

        TypedQuery<UsuarioEntity> query = em.createQuery("Select e From UsuarioEntity e where e.nombre = :nombre", UsuarioEntity.class);
        query = query.setParameter("nombre", nombre);
        List<UsuarioEntity> results = query.getResultList();
        if (results.isEmpty()) {
            return null;
        } else {
            return results.get(0);
        }
    }

    public List<UsuarioEntity> listarUsuarios(){
        LOGGER.info("Consultando todas los usuarios");
        TypedQuery<UsuarioEntity> query = em.createQuery("select u from UsuarioEntity u", UsuarioEntity.class);
        return query.getResultList();
    }

    public UsuarioEntity buscar(Long id) {
        return em.find(UsuarioEntity.class, id);
    }

    public UsuarioEntity actualizar(UsuarioEntity entity) {
         return em.merge(entity);
    }
    
    public void borrar(UsuarioEntity entity) {
        em.remove(entity);
    }

}
