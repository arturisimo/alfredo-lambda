package org.apz.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SortApp {
	
	private final static Logger LOG = LoggerFactory.getLogger(SortApp.class);
	
	
	public static final Set<String> FRUTAS = new TreeSet<>(Arrays.asList("Pear", "Banana", "Apple", "Pineapple", "Orange"));
	
	public static final List<String> NOMBRES = Arrays.asList("Xavier", "Mary", "Kevin", "Jose", "John", "Ana");
	
	public static void main(String[] args) {

		introSortCollection();
		
		introTreeSet();
		
	}

	private static void introSortCollection() {
		
		
		NOMBRES.add("Arthur");
		
		try {
			NOMBRES.add("Xavier");
		} catch (UnsupportedOperationException e) {
			LOG.info("Las listas no permite añadir elementos duplicados");
		}
		
		
		Comparator<String> comparator = (string1, string2) -> string1.compareToIgnoreCase(string2);
		Collections.sort(NOMBRES, comparator);
		
		
		
		
		LOG.info("ordenacion de listas {}", NOMBRES);
		
	}
	
	
	/**
	 * No añade elementos duplicados. Elementos ordenados alfabeticamente ya que String implementa el interfaz comparable
	 */
	private static void introTreeSet() {
        // Duplicate elements are ignored
		FRUTAS.add("Apple");
		FRUTAS.add("Ananas");
		LOG.info("ordenacion con treeset {}", FRUTAS);
		
	}
	
	
}
