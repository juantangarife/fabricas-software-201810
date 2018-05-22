/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comrueda.eventos.eventoFactory;

import comrueda.common.exceptions.BusinessLogicException;
import comrueda.eventos.encuentros.ejb.EncuentroLogic;
import comrueda.eventos.encuentros.resources.EncuentroResource;
import comrueda.eventos.interfaces.EventoDTO;
import comrueda.eventos.interfaces.IEventoResource;
import comrueda.eventos.salidas.ejb.SalidaLogic;
import comrueda.eventos.salidas.resources.SalidaResource;
import java.util.List;
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

/**
 *
 * @author Sistemas
 */
@Path("eventos")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class Eventos implements IEventoResource{
    
    private static IEventoResource delegado;//=FactoryEvento.GetEvento();

    @Inject
    SalidaLogic salidaLogic;
        
    @Inject
    EncuentroLogic encuentroLogic;
   
    public void getEvento(){
        String tipoEvento= "Salida";
        if(tipoEvento.equals("Salida")){
            delegado= new SalidaResource(salidaLogic);
        }
        else if(tipoEvento.equals("Encuentro")){
            delegado= new EncuentroResource(encuentroLogic);
        }
    }
   
    @POST
    @Override
    public EventoDTO crearMiembro(EventoDTO evento) throws BusinessLogicException {
        return delegado.crearMiembro(evento);
    }

    @GET
    @Override
    public List<EventoDTO> getEventos() {
        getEvento();
        return delegado.getEventos();
    }

    @GET
    @Path("{id: \\d+}")
    @Override
    public EventoDTO buscar(@PathParam("id") Long id) {
        return delegado.buscar(id);
    }

    @PUT
    @Path("{id: \\d+}")
    @Override
    public EventoDTO actualizar(@PathParam("id")Long id, EventoDTO evento) throws BusinessLogicException {
        return actualizar(id, evento);
    }

    @DELETE
    @Path("{id: \\d+}")
    public void borrar(@PathParam("id")Long id) throws BusinessLogicException {
        borrar(id);
    }
}
