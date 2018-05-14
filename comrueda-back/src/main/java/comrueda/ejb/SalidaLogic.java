package comrueda.ejb;

import comrueda.entities.SalidaEntity;
import comrueda.persistance.SalidaPersistance;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
public class SalidaLogic {

	private static final Logger LOGGER = Logger.getLogger(SalidaLogic.class.getName());

	@Inject
    private SalidaPersistance persistence;

	public SalidaEntity crearSalida(SalidaEntity entity) {
        LOGGER.info("Inicia proceso de creación de salida");
        persistence.crear(entity);
        LOGGER.info("Termina proceso de creación de salida");
        return entity;
    }

    public List<SalidaEntity> listarSalidas() {
        LOGGER.info("Inicia proceso de consultar todos los salidas");
        List<SalidaEntity> salidas = persistence.listarSalidas();
        LOGGER.info("Termina proceso de consultar todos los salidas");
        return salidas;
    }

    public SalidaEntity buscar(Long id) {
        return persistence.buscar(id);
    }

    public SalidaEntity actualizar(SalidaEntity entity)  {
        return persistence.actualizar(entity);
    }

    public void borrar(SalidaEntity entity) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar salida con id={0}", entity.getId());
        persistence.borrar(entity);
        LOGGER.log(Level.INFO, "Termina proceso de borrar salida con id={0}", entity.getId());
    }

}
