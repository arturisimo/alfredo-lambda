package apz.java;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import apz.java.bean.RSS;

/**
 * Nashorn es un motot de JavaScript que remplaza a Rhino Engine (JDK6)
 * Es un Motor JavaScript ECMA.
 * Consola jjs para ir ejecutando linea a linea o lanzar ficheros JavaScript
 * Java Scripting API (JSR 223): Integración dentro de aplicaciones Java
 * Integración de Java dentro de JavaScript
 */
public class Nashorn {
	
	private String PATH_TMP = "C:/temp/";
	
	
	public Nashorn() {
	}
	
	public String eval(String name) {
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("nashorn");
		String result;
		
		try {
			String jscript = "var welcome ='hola ';" 
					+ "welcome += '" + name +"'";
	
			result = (String)engine.eval(jscript);
	
		} catch (ScriptException e) {
			System.err.println(e.getMessage());
			result = null;
		}
		
		return result;
		
	}
	
	public RSS getRSS() {
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("nashorn");
		RSS rss;
		try {
		
			ClassLoader classLoader = Nashorn.class.getClassLoader();
			File file = new File(classLoader.getResource("scripts/readurl.js").getFile());
			
			try (Reader reader = new FileReader(file)) {
				String result = (String) engine.eval(reader);
				
				File toursFile = new File(PATH_TMP + "tours.xml");
	            // check if file exist, otherwise create the file before writing
	            if (!toursFile.exists()) {
	            	toursFile.createNewFile();
	            }
	            
	            try(FileOutputStream fos = new FileOutputStream(toursFile)) {
	            	byte[] contentInBytes = result.getBytes();
	    			fos.write(contentInBytes);
	            }
	            
	            JAXBContext jaxbContext = JAXBContext.newInstance(RSS.class);
	            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	            rss = (RSS) jaxbUnmarshaller.unmarshal(toursFile);
	            
	    		rss.getChannel().getTours().forEach(tour->System.out.println(tour.getTitle()));
	    		
				
			};
		
		} catch ( ScriptException | JAXBException | IOException e) {
			System.err.println(e.getMessage());
			rss= null;
			e.printStackTrace();
		}
		
		return rss;
		
	}

}
