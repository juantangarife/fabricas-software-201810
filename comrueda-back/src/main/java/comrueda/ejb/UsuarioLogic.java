package comrueda.ejb;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;

import comrueda.entities.UsuarioEntity;
import comrueda.exceptions.BusinessLogicException;
import comrueda.persistance.UsuarioPersistance;

@Stateless
public class UsuarioLogic {
	
	private static final Logger LOGGER = Logger.getLogger(UsuarioLogic.class.getName());
	
	@Inject
    private UsuarioPersistance persistence;
	
	public UsuarioEntity crearUsuario(UsuarioEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de usuario");
        if (persistence.buscarUsuarioNombre(entity.getName()) != null) {
            throw new BusinessLogicException("Ya existe un Usuario con el nombre \"" + entity.getName() + "\"");
        }
        persistence.crear(entity);
        LOGGER.info("Termina proceso de creación de usuario");
        return entity;
    }

    public List<UsuarioEntity> listarUsuarios() {
        LOGGER.info("Inicia proceso de consultar todos las usuarios");
        List<UsuarioEntity> usuarios = persistence.listarUsuarios();
        LOGGER.info("Termina proceso de consultar todos los usuarios");
        return usuarios;
    }

    public UsuarioEntity buscar(Long id) {
        return persistence.buscar(id);
    }

    public UsuarioEntity actualizar(UsuarioEntity entity) throws BusinessLogicException  {
        if (persistence.buscarUsuarioNombre(entity.getName()) != null) {
            throw new BusinessLogicException("Ya existe un usuario con el nombre \"" + entity.getName() + "\"");
        }
        return persistence.actualizar(entity);
    }
    
    public void borrar(UsuarioEntity entity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar usuario con id={0}", entity.getId());    
        persistence.borrar(entity);
        LOGGER.log(Level.INFO, "Termina proceso de borrar usuario con id={0}", entity.getId());
    }

}
