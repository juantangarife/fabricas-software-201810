package comrueda.usuarios.miembros.resources;

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

import comrueda.usuarios.miembros.dtos.MiembroDTO;
import comrueda.usuarios.miembros.ejb.MiembroLogic;
import comrueda.usuarios.miembros.entities.MiembroEntity;
import comrueda.common.exceptions.BusinessLogicException;
import comrueda.usuarios.miembros.persistance.MiembroPersistance;

@Path("miembros")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class MiembroResource {

    @Inject
    MiembroLogic miembroLogic;

    private static final Logger LOGGER = Logger.getLogger(MiembroPersistance.class.getName());

    @GET
    public List<MiembroDTO> getMiembros() {
        return listEntity2DTO(miembroLogic.listarMiembros());
    }

    @POST
    @Path("agregar")
    public MiembroDTO agregarMiembro(MiembroDTO miembro) throws BusinessLogicException {
        MiembroEntity miembroEntity = miembro.toEntity();
        MiembroEntity nuevoMiembro = miembroLogic.crearMiembro(miembroEntity);
        return new MiembroDTO(nuevoMiembro);
    }

    @POST
    @Path("eliminar")
    public List<MiembroDTO> eliminarMiembro(MiembroDTO m) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar un miembro con id {0}", m.getId());
        MiembroEntity entity = miembroLogic.buscar(m.getId());
        miembroLogic.borrar(entity);
        return this.getMiembros();
    }

    /*
    @PUT
    @Path("{id: \\d+}")
    public MiembroDTO actualizar(@PathParam("id") Long id, MiembroDTO miembro) throws BusinessLogicException {
        miembro.setId(id);
        MiembroEntity entity = miembroLogic.buscar(id);
        if (entity == null) {
            throw new BusinessLogicException("El recurso /miembros/" + id + " no existe.");
        }
        return new MiembroDTO(miembroLogic.actualizar(miembro.toEntity()));
    }
    */

    private List<MiembroDTO> listEntity2DTO(List<MiembroEntity> entityList) {
        List<MiembroDTO> list = new ArrayList<MiembroDTO>();
        for (MiembroEntity entity : entityList) {
            list.add(new MiembroDTO(entity));
        }
        return list;
    }
}
