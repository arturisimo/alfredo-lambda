package apz.lambda;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apz.collections.Network;
import org.junit.Test;

public class NetworkTest {
	
	
	public static final Map<String, List<String>> CURSOS;
	static {
		Map<String, List<String>> mapCursos = new HashMap<String, List<String>>();
		mapCursos.put("John", Arrays.asList("C01", "C02", "C09"));
		mapCursos.put("Mary", Arrays.asList("C08", "C06", "C00"));
		mapCursos.put("Kevin", Arrays.asList("C01", "C02", "C00"));
		mapCursos.put("K01", Arrays.asList("C00"));
		mapCursos.put("Jose", Arrays.asList("C04", "C02", "C05"));
		mapCursos.put("jose1", Arrays.asList("C07", "C02", "C05"));
		mapCursos.put("M1", Arrays.asList("C01", "C03", "C04"));
		CURSOS = Collections.unmodifiableMap(mapCursos);
	}
	
	public static final Map<String, List<String>> RELACIONES;
	static {
		Map<String, List<String>> mapCursos = new HashMap<String, List<String>>();
		mapCursos.put("John", Arrays.asList("Mary", "Kevin", "Jose"));
		mapCursos.put("Mary", Arrays.asList("John", "M1"));
		mapCursos.put("M1", Arrays.asList("Mary"));
		mapCursos.put("Kevin", Arrays.asList("John", "Jose", "K01"));
		mapCursos.put("K01", Arrays.asList("Kevin", "jose1"));
		mapCursos.put("Jose", Arrays.asList("John", "Kevin", "jose1"));
		mapCursos.put("jose1", Arrays.asList("Jose", "K01"));
		
		RELACIONES = Collections.unmodifiableMap(mapCursos);
	}
	
	public static final Map<String, Integer> MAP_ORDENADO;
	static {
		Map<String, Integer> mapCursos = new HashMap<String, Integer>();
		mapCursos.put("C02", 4);
		mapCursos.put("C00", 3);
		mapCursos.put("C01", 3);
		mapCursos.put("C04", 2);
		mapCursos.put("C05", 2);
		mapCursos.put("C03", 1);
		mapCursos.put("C06", 1);
		mapCursos.put("C08", 1);
		mapCursos.put("C07", 1);
		mapCursos.put("C09", 1);
		MAP_ORDENADO = Collections.unmodifiableMap(mapCursos);
	}
	
	@Test
	public void testListaOrdenadaCursos() {
		
		Network network = new Network();
		network.setCursos(CURSOS);
		network.setRelaciones(RELACIONES);
		
		Object[] listaAmigos = (Object[]) RELACIONES.keySet().toArray();
		String user = listaAmigos[new Random().nextInt(listaAmigos.length)].toString();
		
		Map<String, Integer> listaOrdenadaCursos = network.getListaCursosOrdenados(user);
		
		assertEquals(MAP_ORDENADO, listaOrdenadaCursos);
		
	}

}
