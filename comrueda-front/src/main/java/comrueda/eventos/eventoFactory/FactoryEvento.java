/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comrueda.eventos.eventoFactory;

import comrueda.eventos.encuentros.resources.EncuentroResource;
import comrueda.eventos.interfaces.EventoResource;
import comrueda.eventos.salidas.resources.SalidaResource;

/**
 *
 * @author Sistemas
 */
public class FactoryEvento {

    public static EventoResource GetEvento() {
		String tipoEvento= ConfigBehavior.GetProperty("Comunidad.TipoEvento");
		if(tipoEvento.equals("Salida")){
			return new SalidaResource();
		}
		else if(tipoEvento.equals("Encuentro")){
			return new EncuentroResource();
		}
		return null;
    }
}
