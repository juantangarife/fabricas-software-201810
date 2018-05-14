package comrueda.ejb;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;

import comrueda.entities.MiembroEntity;
import comrueda.exceptions.BusinessLogicException;
import comrueda.persistance.MiembroPersistance;

@Stateless
public class MiembroLogic {
	
	private static final Logger LOGGER = Logger.getLogger(MiembroLogic.class.getName());
	
	@Inject
    private MiembroPersistance persistence;
	
	public MiembroEntity crearMiembro(MiembroEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de miembro");
        if (persistence.buscarMiembroCorreo(entity.getCorreo()) != null) {
            throw new BusinessLogicException("Ya existe un miembro con el correo \"" + entity.getCorreo() + "\"");
        }
        persistence.crear(entity);
        LOGGER.info("Termina proceso de creación de mienbro");
        return entity;
    }

    public List<MiembroEntity> listarMiembros() {
        LOGGER.info("Inicia proceso de consultar todos los miembros");
        List<MiembroEntity> miembros = persistence.listarMiembros();
        LOGGER.info("Termina proceso de consultar todos los miembros");
        return miembros;
    }

    public MiembroEntity buscar(Long id) {
        return persistence.buscar(id);
    }

    public MiembroEntity actualizar(MiembroEntity entity) throws BusinessLogicException  {
        if (persistence.buscarMiembroCorreo(entity.getCorreo()) != null) {
            throw new BusinessLogicException("Ya existe un miembro con el correo \"" + entity.getCorreo() + "\"");
        }
        return persistence.actualizar(entity);
    }
    
    public void borrar(MiembroEntity entity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar miembro con id={0}", entity.getId());
        persistence.borrar(entity);
        LOGGER.log(Level.INFO, "Termina proceso de borrar miembro con id={0}", entity.getId());
    }

}
