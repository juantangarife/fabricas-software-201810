package comrueda.back.aspect;

public aspect LoggerAspect {
	
	// todos los métodos en los paquetes comrueda.*.ejb.*
	pointcut logger():
		execution(* comrueda..ejb..*(..)) ;
		
	before():logger(){
		System.out.println("Inicio de ejecucion del metodo: " + thisJoinPoint);
		// Log.DebugLog("Inicio de ejecucion del metodo: " + thisJoinPoint);
	}
	
	after() returning(Object r):logger(){
		System.out.println("Metodo " + r + " Retorno correctamente");
		// Log.DebugLog("Metodo " + r + " Retorno correctamente");
	}
	
	after() throwing(Throwable e):logger(){
		System.out.println("Excepcion en el metodo: " + e);
		// Log.DebugLog("Excepcion en el metodo: " + e);
	}
}