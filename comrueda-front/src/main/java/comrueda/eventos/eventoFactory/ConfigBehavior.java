/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comrueda.eventos.eventoFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Sistemas
 */
public class ConfigBehavior {

	private static Properties misPropiedades;
		
	public static String GetProperty(String property){
		ReadConfig();
		return ConfigBehavior.misPropiedades.getProperty(property);
	}
	
	
	private static void ReadConfig(){
		String ruta = new File("").getAbsolutePath();
		misPropiedades = new Properties();
		try {
			   misPropiedades.load(new BufferedReader(new FileReader(ruta + "/src/miAplicacion.properties")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
