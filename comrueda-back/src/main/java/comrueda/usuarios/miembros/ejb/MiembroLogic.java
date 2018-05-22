package comrueda.usuarios.miembros.ejb;

import comrueda.usuarios.miembros.entities.MiembroEntity;
import comrueda.common.exceptions.BusinessLogicException;
import comrueda.usuarios.miembros.persistance.MiembroPersistance;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
public class MiembroLogic {
	
	private static final Logger LOGGER = Logger.getLogger(MiembroLogic.class.getName());
	
	@Inject
    private MiembroPersistance persistence;

	public MiembroEntity autenticarMiembro(String correo, String password) throws BusinessLogicException{
	    boolean correoValido = correo != null && !correo.equals("");
	    boolean passwordValido = password != null && password.equals("");
        if (correoValido && passwordValido) {
            throw new BusinessLogicException("El correo y la contraseña son obligatorios");
        }
	    return this.persistence.autenticarMiembro(correo, password);
    }
	
	public MiembroEntity crearMiembro(MiembroEntity entity) throws BusinessLogicException {
        if (persistence.buscarMiembroCorreo(entity.getCorreo()) != null) {
            throw new BusinessLogicException("Ya existe un miembro con el correo \"" + entity.getCorreo() + "\"");
        }
        persistence.crear(entity);
        return entity;
    }

    public List<MiembroEntity> listarMiembros() {
        List<MiembroEntity> miembros = persistence.listarMiembros();
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
