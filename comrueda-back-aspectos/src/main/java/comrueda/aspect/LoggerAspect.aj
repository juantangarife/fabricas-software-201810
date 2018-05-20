package comrueda.aspect;
import java.io.IOException;
import util.*;


import comrueda.usuarios.miembros.*;

public aspect LoggerAspect {
	
	
	pointcut logger():
		call(public * MiembroLogic.*(. .));
		
	before():logger(){
		System.out.println("Inicio de ejecucion del metodo: " + thisJoinPoint);
		Log.DebugLog("Inicio de ejecucion del metodo: " + thisJoinPoint);
	}
	
	after() returning(Object r):logger(){
		System.out.println("Metodo " + r + " Retorno correctamente");
		Log.DebugLog("Metodo " + r + " Retorno correctamente");
	}
	
	after() throwing(Throwable e):logger(){
		System.out.println("Excepcion en el metodo: " + e);
		Log.DebugLog("Excepcion en el metodo: " + e);
	}
}