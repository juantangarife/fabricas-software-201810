/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comrueda.eventos.eventoFactory;

import comrueda.eventos.encuentros.entities.EncuentroEntity;
import comrueda.eventos.entities.EventoEntity;
import comrueda.eventos.salidas.entities.SalidaEntity;

/**
 *
 * @author Sistemas
 */
public class FactoryEvento {

    public static EventoEntity GetEvento() {
		String tipoEvento= ConfigBehavior.GetProperty("Comunidad.TipoEvento");
		if(tipoEvento.equals("Salida")){
			return new SalidaEntity();
		}
		else if(tipoEvento.equals("Encuentro")){
			return new EncuentroEntity();
		}
		return null;
	}
}
