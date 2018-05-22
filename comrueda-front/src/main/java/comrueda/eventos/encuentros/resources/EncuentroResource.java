package comrueda.eventos.encuentros.resources;

import comrueda.eventos.encuentros.dtos.EncuentroDTO;
import comrueda.eventos.encuentros.ejb.EncuentroLogic;
import comrueda.eventos.encuentros.entities.EncuentroEntity;
import comrueda.common.exceptions.BusinessLogicException;
import comrueda.eventos.salidas.persistance.SalidaPersistance;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("encuentros")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class EncuentroResource {

	@Inject
	EncuentroLogic encuentroLogic;

	private static final Logger LOGGER = Logger.getLogger(SalidaPersistance.class.getName());

	@POST
	public EncuentroDTO crearMiembro(EncuentroDTO encuentro) throws BusinessLogicException {
		EncuentroEntity encuentroEntity = encuentro.toEntity();
		EncuentroEntity nuevoMiembro = encuentroLogic.crearEncuentro(encuentroEntity);
		return new EncuentroDTO(nuevoMiembro);
	}

	@GET
	public List<EncuentroDTO> getEncuentros() {
		return listEntity2DTO(encuentroLogic.listarEncuentros());
	}

	@GET
	@Path("{id: \\d+}")
	public EncuentroDTO buscar(@PathParam("id") Long id) {
		EncuentroEntity entity = encuentroLogic.buscar(id);
		if (entity != null) {
			return new EncuentroDTO(entity);
		}
		return null;
	}

	@PUT
	@Path("{id: \\d+}")
	public EncuentroDTO actualizar(@PathParam("id") Long id, EncuentroDTO encuentro) throws BusinessLogicException {
		encuentro.setId(id);
        EncuentroEntity entity = encuentroLogic.buscar(id);
        if (entity == null) {
            throw new BusinessLogicException("El recurso /salidas/" + id + " no existe.");
        }
        return new EncuentroDTO(encuentroLogic.actualizar(encuentro.toEntity()));
	}

	@DELETE
	@Path("{id: \\d+}")
	public void borrar(@PathParam("id") Long id) throws BusinessLogicException {
		LOGGER.log(Level.INFO, "Inicia proceso de borrar una salida con id {0}", id);
        EncuentroEntity entity = encuentroLogic.buscar(id);
		encuentroLogic.borrar(entity);
	}

	private List<EncuentroDTO> listEntity2DTO(List<EncuentroEntity> entityList) {
		List<EncuentroDTO> list = new ArrayList<EncuentroDTO>();
		for (EncuentroEntity entity : entityList) {
			list.add(new EncuentroDTO(entity));
		}
		return list;
	}
}
