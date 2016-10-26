package apz.java;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/**
 * Obtener una lista de los cursos recibidos por un grupo de amigos. 
 * Este grupo es una red social (de 3 niveles de grado de amistad como m√°ximo) 
 * El orden de la lista esta definido por el numero de personas que ha recibido el curso
 *
 */
public class Network {
	
	
	public Network() {}
 	
	private Map<String, List<String>> cursos;
	private Map<String, List<String>> relaciones;
	
	
	public Map<String, List<String>> getCursos() {
		return cursos;
	}

	public void setCursos(Map<String, List<String>> cursos) {
		this.cursos = cursos;
	}

	public Map<String, List<String>> getRelaciones() {
		return relaciones;
	}

	public void setRelaciones(Map<String, List<String>> relaciones) {
		this.relaciones = relaciones;
	}

	
	/**
	 * Obtener una lista de los cursos recibidos por un grupo de amigos. 
	 * Este grupo es una red social (de 3 niveles de grado de amistad como m·ximo) 
	 * El orden de la lista esta definido por el numero de personas que ha recibido el curso
	 * @param user
	 * @return
	 */
	public Map<String, Integer> getListaCursosOrdenados(String user) {
		
		//map con persona y cursos
		Map<String, List<String>> redSocialCursos = new HashMap<>();
		redSocialCursos.put(user, cursos.get(user));
		
		loadRedSocial(user, redSocialCursos);
		
		printRedSocial(redSocialCursos, user);
		
		//map de cursos con el numero de personas que lo ha recibido
		Map<String, Integer> mapCursos = new HashMap<>();
		
		redSocialCursos.forEach((amigo, cursos) -> {
			
			cursos.forEach(curso -> {
				if(mapCursos.containsKey(curso)) {
					mapCursos.put(curso, mapCursos.get(curso)+1);
				} else {
					mapCursos.put(curso, 1);
				}
			});
		});
		
		//map de cursos ordenados por valor (numero de personas que lo ha recibido)
		Map<String, Integer> mapCursosOrdenado = new LinkedHashMap<>();
		
		mapCursos.entrySet().stream()
          				.sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
          				.forEachOrdered(x -> mapCursosOrdenado.put(x.getKey(), x.getValue()));
		
		//imprimir cursos ordenados
		mapCursosOrdenado.forEach((curso, num) -> System.out.println(num +" personas han asistido al curso " + curso));
		
		return mapCursosOrdenado;
	}

	/**
	 * metodo recursivo para obtener un map de amigos/cursos
	 * @param user
	 * @return
	 */
	private void loadRedSocial(String user, Map<String, List<String>> redSocialCursos) {
		
		if(redSocialCursos.size() < cursos.size()) { 
			
			List<String> amigosDirectos = relaciones.get(user);
			
			amigosDirectos.stream()
						  .filter(amigo -> !redSocialCursos.containsKey(amigo))
						  .forEach(amigo -> {
							  redSocialCursos.put(amigo, cursos.get(amigo));
							  loadRedSocial(amigo, redSocialCursos);
						  });
		}
	}
	
	private static void printRedSocial(Map<String, List<String>> redSocialCursos, String user) {
		
		StringBuilder sb = new StringBuilder("-----------RED-SOCIAL-DE-").append(user).append("----------\n");
		
		redSocialCursos.forEach((amigo, cursos) -> {
			sb.append(amigo).append(" [");
			cursos.forEach(curso->{
				sb.append(curso).append(",");
			});
			sb.append("] \n");
		});
		System.out.println(sb.append("------------------------------\n").toString());
	}
	
}
