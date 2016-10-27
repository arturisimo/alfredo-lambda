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
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import apz.java.bean.rss.RSS;

/**
 * Nashorn es un motot de JavaScript que remplaza a Rhino Engine (JDK6)
 * Es un Motor JavaScript ECMA.
 * Consola jjs para ir ejecutando linea a linea o lanzar ficheros JavaScript
 * Java Scripting API (JSR 223): Integración dentro de aplicaciones Java
 * Integración de Java dentro de JavaScript
 */
public class Nashorn {
	
	public Nashorn() {
	}
	
	public static void main(String[] args) {
		
		try {
			eval("Pepe");	
		
			file();
		} catch ( ScriptException | JAXBException | SAXException | IOException | ParserConfigurationException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void eval(String name) throws ScriptException {
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("nashorn");
		
		String jscript = "var welcome ='Hello ';" 
						+ "welcome += '" + name +"'";
		
		String result;
		result = (String)engine.eval(jscript);
		System.out.println(result);
		
	}
	
	public static void file() throws ScriptException, JAXBException, ParserConfigurationException, SAXException, IOException {
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("nashorn");
		
		ClassLoader classLoader = Nashorn.class.getClassLoader();
		File file = new File(classLoader.getResource("scripts/readurl.js").getFile());
		
		try (Reader reader = new FileReader(file)) {
			String result = (String) engine.eval(reader);
			
			File toursFile = new File("D:/tours.xml");
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
    		RSS tours = (RSS) jaxbUnmarshaller.unmarshal(toursFile);
    		
			tours.getChannel().getTours().forEach(tour -> System.out.println(tour.getTitle()));
			
			
		};
		
	}

}
