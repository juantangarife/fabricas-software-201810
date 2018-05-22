/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comrueda.eventos.interfaces;

import comrueda.eventos.entities.EventoEntity;
import java.util.List;



/**
 *
 * @author Sistemas
 */
public interface EventoLogic {
    
    EventoEntity crearEvento(EventoEntity entity);

    List<EventoEntity> listarEventos();

    EventoEntity buscar(Long id);

    EventoEntity actualizar(EventoEntity entity);

    void borrar(EventoEntity entity);
    
}
