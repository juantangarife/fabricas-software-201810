/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comrueda.eventos.eventoFactory;

import comrueda.eventos.encuentros.resources.EncuentroResource;
import comrueda.eventos.salidas.resources.SalidaResource;
import comrueda.eventos.interfaces.IEventoResource;

/**
 *
 * @author Sistemas
 */
public class FactoryEvento {

    /*
    public static IEventoResource GetEvento() {
        String tipoEvento= ConfigBehavior.GetProperty("Comunidad.TipoEvento");
        if(tipoEvento.equals("Salida")){
            return new SalidaResource();
        }
        else if(tipoEvento.equals("Encuentro")){
            return new EncuentroResource();
        }
        return null;
    }
    */
}
