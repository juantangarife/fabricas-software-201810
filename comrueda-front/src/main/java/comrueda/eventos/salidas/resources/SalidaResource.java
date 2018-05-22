package comrueda.eventos.salidas.resources;

import comrueda.eventos.salidas.dtos.SalidaDTO;
import comrueda.eventos.salidas.ejb.SalidaLogic;
import comrueda.eventos.salidas.entities.SalidaEntity;
import comrueda.common.exceptions.BusinessLogicException;
import comrueda.eventos.interfaces.EventoDTO;
import comrueda.eventos.salidas.persistance.SalidaPersistance;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import comrueda.eventos.interfaces.IEventoResource;

public class SalidaResource implements IEventoResource {

    SalidaLogic salidaLogic;

    private static final Logger LOGGER = Logger.getLogger(SalidaPersistance.class.getName());

    public SalidaResource(SalidaLogic salidaLogic) {
        this.salidaLogic = salidaLogic;
    }

    @Override
    public EventoDTO buscar(Long id) {
        SalidaEntity entity = salidaLogic.buscar(id);
        if (entity != null) {
            return new SalidaDTO(entity);
        }
        return null;
    }

    @Override
    public void borrar(Long id) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar una salida con id {0}", id);
        SalidaEntity entity = salidaLogic.buscar(id);
        salidaLogic.borrar(entity);
    }

    @Override
    public EventoDTO crearEvento(EventoDTO evento) throws BusinessLogicException {
        SalidaEntity salidaEntity = (SalidaEntity) evento.toEntity();
        SalidaEntity nuevaSalida = salidaLogic.crearSalida(salidaEntity);
        return new SalidaDTO(nuevaSalida);
    }

    @Override
    public List<EventoDTO> getEventos() {
        return listEntity2DTO(salidaLogic.listarSalidas());
    }

    @Override
    public EventoDTO actualizar(Long id, EventoDTO evento) throws BusinessLogicException {
        SalidaDTO encuentro = (SalidaDTO) evento;
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
