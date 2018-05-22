package comrueda.eventos.encuentros.ejb;

import comrueda.eventos.encuentros.ejb.*;
import comrueda.eventos.encuentros.entities.EncuentroEntity;
import comrueda.eventos.encuentros.persistance.EncuentroPersistance;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
public class EncuentroLogic {

	private static final Logger LOGGER = Logger.getLogger(EncuentroLogic.class.getName());

	@Inject
    private EncuentroPersistance persistence;

	public EncuentroEntity crearEncuentro(EncuentroEntity entity) {
        LOGGER.info("Inicia proceso de creación de salida");
        persistence.crear(entity);
        LOGGER.info("Termina proceso de creación de salida");
        return entity;
    }

    public List<EncuentroEntity> listarEncuentros() {
        LOGGER.info("Inicia proceso de consultar todos los encuentros");
        List<EncuentroEntity> salidas = persistence.listarEncuentros();
        LOGGER.info("Termina proceso de consultar todos los encuentros");
        return salidas;
    }

    public EncuentroEntity buscar(Long id) {
        return persistence.buscar(id);
    }

    public EncuentroEntity actualizar(EncuentroEntity entity)  {
        return persistence.actualizar(entity);
    }

    public void borrar(EncuentroEntity entity) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar salida con id={0}", entity.getId());
        persistence.borrar(entity);
        LOGGER.log(Level.INFO, "Termina proceso de borrar salida con id={0}", entity.getId());
    }

}
