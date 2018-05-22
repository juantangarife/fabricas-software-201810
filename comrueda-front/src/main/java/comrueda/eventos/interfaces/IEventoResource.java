/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comrueda.eventos.interfaces;

import comrueda.common.exceptions.BusinessLogicException;
import comrueda.eventos.entities.EventoEntity;
import comrueda.eventos.salidas.dtos.SalidaDTO;
import comrueda.eventos.salidas.ejb.SalidaLogic;
import comrueda.eventos.salidas.entities.SalidaEntity;
import comrueda.eventos.salidas.persistance.SalidaPersistance;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author Sistemas
 */
public interface IEventoResource {

	EventoDTO crearMiembro(EventoDTO evento) throws BusinessLogicException;

	List<EventoDTO> getEventos();

	EventoDTO buscar(Long id);

	EventoDTO actualizar(Long id, EventoDTO evento) throws BusinessLogicException;

	void borrar( Long id) throws BusinessLogicException;

	//public abstract List<EventoDTO> listEntity2DTO(List<EventoEntity> entityList);
}
