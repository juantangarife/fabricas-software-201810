/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comrueda.aspect;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author Sistemas
 */
public class Log {
    public static void DebugLog(String logLine){
        Logger logger = Logger.getLogger("MyLog");  
        FileHandler fh;  

        try {  
            // This block configure the logger with handler and formatter
            Directory();
            String ruta=System.getProperty("user.dir") + "\\Logs\\comunidad.log";
            System.out.println(ruta);
            fh = new FileHandler(ruta,true);  
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();  
            fh.setFormatter(formatter);  

            // the following statement is used to log any messages  
            logger.info(logLine);  

        } catch (SecurityException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  

        //logger.info("Hi How r u?");  
    }

    private static void Directory(){
            File files = new File("C:\\Users\\Sistemas\\Documents\\logs");//System.getProperty("user.dir") + "\\Logs");
    if (!files.exists()) {
        if (files.mkdirs()) {
            System.out.println("Multiple directories are created!");
        } else {
            System.out.println("Failed to create multiple directories!");
        }
    }
    }
}
