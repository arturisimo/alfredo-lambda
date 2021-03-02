package org.apz.tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Uso de genericos. N-ary Tree 
 * 
 * Se usa la classe Tree<T> y Node<T> son clases genéricas. T es un par�metro de tipo que ser� reemplazado por un tipo real cuando se crea un objeto de tipo Gen.
 * 
 *
 */
public class TreeApp {
	
	private final static Logger LOG = LoggerFactory.getLogger(TreeApp.class);
	
	private static Map<String, Node<String>> letras;
	
	public static void main(String[] args) {
		try {
		
			try (BufferedReader br = new BufferedReader(new InputStreamReader(TreeApp.class.getClassLoader().getResourceAsStream("tree2.txt")))) {
	
				letras = br.lines().map(letra -> letra.split("="))
													 .map(fields -> getNode(fields))
													 .collect(Collectors.toMap(node->node.getData(), node->node));
				
				letras.forEach((key, letra) -> letras.put(key, populateChild(letra)));
						
				letras.values().forEach(node -> LOG.info(node.toStringVerbose()));
				
				Tree<String> abecedario = new Tree<>(letras.get("abecedario"));
				LOG.info(abecedario.getRoot().toString());
				LOG.info(abecedario.getRoot().toStringVerbose());
				LOG.info(abecedario.toStringWithDepth());
				LOG.info("number of nodes {}", abecedario.getNumberOfNodes());
			
	        }
			
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
		
	}
	
	private static Node<String> populateChild(Node<String> letra) {
		for (Node<String> child : letras.get(letra.getData()).getChildren()) {
			letra.addChild(populateChild(child));
		}
		return letra;
	}

	private static Node<String> getNode(String data[]) {
		Node<String> node = new Node<>(data[0]);
		try {
			for (String child : data[1].split(",")) {
				node.addChild(new Node<>(child));
			}
			
		} catch (ArrayIndexOutOfBoundsException e) {
		}
		return node;
	}
	
	
	
}
