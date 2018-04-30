package comrueda.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import comrueda.dtos.UsuarioDTO;
import comrueda.ejb.UsuarioLogic;
import comrueda.entities.UsuarioEntity;
import comrueda.exceptions.BusinessLogicException;
import comrueda.persistance.UsuarioPersistance;

@Path("usuarios")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class UsuarioResource {

	@Inject
	UsuarioLogic usuarioLogic;

	private static final Logger LOGGER = Logger.getLogger(UsuarioPersistance.class.getName());

	@POST
	public UsuarioDTO crearUsuario(UsuarioDTO usuario) throws BusinessLogicException {
		UsuarioEntity usuarioEntity = usuario.toEntity();
		UsuarioEntity nuevoUsuario = usuarioLogic.crearUsuario(usuarioEntity);
		return new UsuarioDTO(nuevoUsuario);
	}

	@GET
	public List<UsuarioDTO> getEditorials() {
		return listEntity2DTO(usuarioLogic.listarUsuarios());
	}

	@GET
	@Path("{id: \\d+}")
	public UsuarioDTO buscar(@PathParam("id") Long id) {
		UsuarioEntity entity = usuarioLogic.buscar(id);
		if (entity != null) {
			return new UsuarioDTO(entity);
		}
		return null;
	}

	@PUT
	@Path("{id: \\d+}")
	public UsuarioDTO actualizar(@PathParam("id") Long id, UsuarioDTO usuario) throws BusinessLogicException {
		usuario.setId(id);
        UsuarioEntity entity = usuarioLogic.buscar(id);
        if (entity == null) {
            throw new BusinessLogicException("El recurso /usuarios/" + id + " no existe.");
        }
        return new UsuarioDTO(usuarioLogic.actualizar(usuario.toEntity()));
	}

	@DELETE
	@Path("{id: \\d+}")
	public void borrar(@PathParam("id") Long id) throws BusinessLogicException {
		LOGGER.log(Level.INFO, "Inicia proceso de borrar un usuario con id {0}", id);
        UsuarioEntity entity = usuarioLogic.buscar(id);
        usuarioLogic.borrar(entity);
	}

	private List<UsuarioDTO> listEntity2DTO(List<UsuarioEntity> entityList) {
		List<UsuarioDTO> list = new ArrayList<UsuarioDTO>();
		for (UsuarioEntity entity : entityList) {
			list.add(new UsuarioDTO(entity));
		}
		return list;
	}
}
