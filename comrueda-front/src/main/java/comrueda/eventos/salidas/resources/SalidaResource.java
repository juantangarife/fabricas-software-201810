package comrueda.eventos.salidas.resources;

import comrueda.eventos.salidas.dtos.SalidaDTO;
import comrueda.eventos.salidas.ejb.SalidaLogic;
import comrueda.eventos.salidas.entities.SalidaEntity;
import comrueda.common.exceptions.BusinessLogicException;
import comrueda.eventos.salidas.persistance.SalidaPersistance;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("salidas")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class SalidaResource {

	@Inject
	SalidaLogic salidaLogic;

	private static final Logger LOGGER = Logger.getLogger(SalidaPersistance.class.getName());

	@POST
	public SalidaDTO crearMiembro(SalidaDTO salida) throws BusinessLogicException {
		SalidaEntity salidaEntity = salida.toEntity();
		SalidaEntity nuevoMiembro = salidaLogic.crearSalida(salidaEntity);
		return new SalidaDTO(nuevoMiembro);
	}

	@GET
	public List<SalidaDTO> getSalidas() {
		return listEntity2DTO(salidaLogic.listarSalidas());
	}

	@GET
	@Path("{id: \\d+}")
	public SalidaDTO buscar(@PathParam("id") Long id) {
		SalidaEntity entity = salidaLogic.buscar(id);
		if (entity != null) {
			return new SalidaDTO(entity);
		}
		return null;
	}

	@PUT
	@Path("{id: \\d+}")
	public SalidaDTO actualizar(@PathParam("id") Long id, SalidaDTO salida) throws BusinessLogicException {
		salida.setId(id);
        SalidaEntity entity = salidaLogic.buscar(id);
        if (entity == null) {
            throw new BusinessLogicException("El recurso /salidas/" + id + " no existe.");
        }
        return new SalidaDTO(salidaLogic.actualizar(salida.toEntity()));
	}

	@DELETE
	@Path("{id: \\d+}")
	public void borrar(@PathParam("id") Long id) throws BusinessLogicException {
		LOGGER.log(Level.INFO, "Inicia proceso de borrar una salida con id {0}", id);
        SalidaEntity entity = salidaLogic.buscar(id);
		salidaLogic.borrar(entity);
	}

	private List<SalidaDTO> listEntity2DTO(List<SalidaEntity> entityList) {
		List<SalidaDTO> list = new ArrayList<SalidaDTO>();
		for (SalidaEntity entity : entityList) {
			list.add(new SalidaDTO(entity));
		}
		return list;
	}
}
