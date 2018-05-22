package comrueda.eventos.salidas.resources;

import comrueda.eventos.salidas.dtos.SalidaDTO;
import comrueda.eventos.salidas.ejb.SalidaLogic;
import comrueda.eventos.salidas.entities.SalidaEntity;
import comrueda.common.exceptions.BusinessLogicException;
import comrueda.eventos.interfaces.EventoDTO;
import comrueda.eventos.interfaces.EventoResource;
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
public class SalidaResource extends EventoResource{

	@Inject
	SalidaLogic salidaLogic;

	private static final Logger LOGGER = Logger.getLogger(SalidaPersistance.class.getName());

	@GET
	@Path("{id: \\d+}")
        @Override
	public EventoDTO buscar(@PathParam("id") Long id) {
		SalidaEntity entity = salidaLogic.buscar(id);
		if (entity != null) {
			return new SalidaDTO(entity);
		}
		return null;
	}

	@DELETE
	@Path("{id: \\d+}")
	public void borrar(@PathParam("id") Long id) throws BusinessLogicException {
		LOGGER.log(Level.INFO, "Inicia proceso de borrar una salida con id {0}", id);
        SalidaEntity entity = salidaLogic.buscar(id);
		salidaLogic.borrar(entity);
	}


    @POST
    @Override
    public EventoDTO crearMiembro(EventoDTO evento) throws BusinessLogicException {
        SalidaEntity encuentroEntity = (SalidaEntity)evento.toEntity();
	SalidaEntity nuevoMiembro = salidaLogic.crearSalida(encuentroEntity);
	return new SalidaDTO(nuevoMiembro);
    }

    @GET
    @Override
    public List<EventoDTO> getEventos() {
        return listEntity2DTO(salidaLogic.listarSalidas());
    }
    
    @PUT
    @Path("{id: \\d+}")
    @Override
    public EventoDTO actualizar(@PathParam("id")Long id, EventoDTO evento) throws BusinessLogicException {
        SalidaDTO encuentro=(SalidaDTO)evento;
        encuentro.setId(id);
        
        SalidaEntity entity = salidaLogic.buscar(id);
        
        if (entity == null) {
            throw new BusinessLogicException("El recurso /salidas/" + id + " no existe.");
        }
        return new SalidaDTO(salidaLogic.actualizar(encuentro.toEntity()));
    }
    
    
        
    private List<EventoDTO> listEntity2DTO(List<SalidaEntity> entityList) {
            List<EventoDTO> list = new ArrayList<EventoDTO>();
            for (SalidaEntity entity : entityList) {
                    list.add(new SalidaDTO(entity));
            }
            return list;
    }
}
