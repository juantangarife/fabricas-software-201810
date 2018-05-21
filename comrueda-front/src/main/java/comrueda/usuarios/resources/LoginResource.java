package comrueda.usuarios.resources;

import comrueda.common.exceptions.BusinessLogicException;
import comrueda.usuarios.dtos.LoginDTO;
import comrueda.usuarios.miembros.dtos.MiembroDTO;
import comrueda.usuarios.miembros.ejb.MiembroLogic;
import comrueda.usuarios.miembros.entities.MiembroEntity;
import comrueda.usuarios.miembros.persistance.MiembroPersistance;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.logging.Logger;

@Path("login")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class LoginResource {

    @Inject
    MiembroLogic miembroLogic;

    private static final Logger LOGGER = Logger.getLogger(MiembroPersistance.class.getName());

    @POST
    public MiembroDTO login(LoginDTO loginData) throws BusinessLogicException {
        MiembroEntity miembroAutenticado = miembroLogic.autenticarMiembro(loginData.getCorreo(), loginData.getPassword());
        if (miembroAutenticado != null){
            return new MiembroDTO(miembroAutenticado);
        }
        else{
            throw new BusinessLogicException("Credenciales erróneas. Por favor vuelva a intentar");
        }
    }
}
