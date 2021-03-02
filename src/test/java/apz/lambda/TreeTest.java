package apz.lambda;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.stream.Collectors;

import org.apz.tree.Node;
import org.apz.tree.Tree;
import org.apz.tree.TreeApp;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TreeTest {
	
	private final static Logger LOG = LoggerFactory.getLogger(TreeApp.class);
	
	private static Map<String, Node<String>> letras;
	
	@Test
	public void abecedario() {
		try {
		
			try (BufferedReader br = new BufferedReader(new InputStreamReader(TreeApp.class.getClassLoader().getResourceAsStream("tree2.txt")))) {
	
				letras = br.lines().map(letra -> letra.split("="))
													 .map(this::getNode)
													 .collect(Collectors.toMap(node->node.getData(), node->node));
				
				letras.forEach((key, letra) -> letras.put(key, populateChild(letra)));
						
				//letras.values().forEach(node -> LOG.info(node.toStringVerbose()));
				
				Tree<String> abecedario = new Tree<>(letras.get("abecedario"));
				LOG.info(abecedario.getRoot().toString());
				LOG.info(abecedario.getRoot().toStringVerbose());
				LOG.info(abecedario.toStringWithDepth());
				LOG.info("number of nodes {}", abecedario.getNumberOfNodes());
				assert(abecedario.getNumberOfNodes() == 27);
			
	        }
			
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
		
	}
	
	private Node<String> populateChild(Node<String> letra) {
		letras.get(letra.getData()).getChildren().forEach(child -> letra.addChild(populateChild(child)));
		return letra;
	}

	private Node<String> getNode(String data[]) {
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
