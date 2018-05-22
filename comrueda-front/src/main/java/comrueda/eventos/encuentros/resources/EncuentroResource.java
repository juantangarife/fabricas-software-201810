package comrueda.eventos.encuentros.resources;

import comrueda.eventos.encuentros.dtos.EncuentroDTO;
import comrueda.eventos.encuentros.ejb.EncuentroLogic;
import comrueda.eventos.encuentros.entities.EncuentroEntity;
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

@Path("encuentros")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class EncuentroResource extends EventoResource {

	@Inject
	EncuentroLogic encuentroLogic;

	private static final Logger LOGGER = Logger.getLogger(SalidaPersistance.class.getName());

	@GET
	@Path("{id: \\d+}")
        @Override
	public EventoDTO buscar(@PathParam("id") Long id) {
		EncuentroEntity entity = encuentroLogic.buscar(id);
		if (entity != null) {
			return new EncuentroDTO(entity);
		}
		return null;
	}

	@DELETE
	@Path("{id: \\d+}")
	public void borrar(@PathParam("id") Long id) throws BusinessLogicException {
		LOGGER.log(Level.INFO, "Inicia proceso de borrar una salida con id {0}", id);
        EncuentroEntity entity = encuentroLogic.buscar(id);
		encuentroLogic.borrar(entity);
	}


    @POST
    @Override
    public EventoDTO crearMiembro(EventoDTO evento) throws BusinessLogicException {
        EncuentroEntity encuentroEntity = (EncuentroEntity)evento.toEntity();
	EncuentroEntity nuevoMiembro = encuentroLogic.crearEncuentro(encuentroEntity);
	return new EncuentroDTO(nuevoMiembro);
    }

    @GET
    @Override
    public List<EventoDTO> getEventos() {
        return listEntity2DTO(encuentroLogic.listarEncuentros());
    }
    
    @PUT
    @Path("{id: \\d+}")
    @Override
    public EventoDTO actualizar(@PathParam("id")Long id, EventoDTO evento) throws BusinessLogicException {
        EncuentroDTO encuentro=(EncuentroDTO)evento;
        encuentro.setId(id);
        
        EncuentroEntity entity = encuentroLogic.buscar(id);
        
        if (entity == null) {
            throw new BusinessLogicException("El recurso /salidas/" + id + " no existe.");
        }
        return new EncuentroDTO(encuentroLogic.actualizar(encuentro.toEntity()));
    }
    
    
        
    private List<EventoDTO> listEntity2DTO(List<EncuentroEntity> entityList) {
            List<EventoDTO> list = new ArrayList<EventoDTO>();
            for (EncuentroEntity entity : entityList) {
                    list.add(new EncuentroDTO(entity));
            }
            return list;
    }
}
