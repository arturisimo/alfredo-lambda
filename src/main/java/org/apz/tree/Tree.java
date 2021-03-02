package org.apz.tree;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * N-ary Tree
 *
 * @param <T>
 */
public class Tree<T> {

    private Node<T> root;

    public enum TraversalOrder {
    	PRE_ORDER,
    	POST_ORDER
    }

    
    public Tree() {
        super();
    }
    
    public Tree(Node<T> root) {
        super();
        this.root = root;
    }
    
    public Node<T> getRoot() {
        return this.root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }
   
    public int getNumberOfNodes() {
        int numberOfNodes = 0;

        if(root != null) {
            numberOfNodes = auxiliaryGetNumberOfNodes(root) + 1; //1 for the root!
        }

        return numberOfNodes;
    }

    private int auxiliaryGetNumberOfNodes(Node<T> node) {
        int numberOfNodes = node.getNumberOfChildren();

        for(Node<T> child : node.getChildren()) {
            numberOfNodes += auxiliaryGetNumberOfNodes(child);
        }

        return numberOfNodes;
    }

    public boolean isEmpty() {
        return (root == null);
    }

    public List<Node<T>> build(TraversalOrder traversalOrder) {
        List<Node<T>> returnList = null;

        if(root != null) {
            returnList = build(root, traversalOrder);
        }

        return returnList;
    }

    public List<Node<T>> build(Node<T> node, TraversalOrder traversalOrder) {
        List<Node<T>> traversalResult = new ArrayList<Node<T>>();

        if(traversalOrder == TraversalOrder.PRE_ORDER) {
            buildPreOrder(node, traversalResult);
        }

        else if(traversalOrder == TraversalOrder.POST_ORDER) {
            buildPostOrder(node, traversalResult);
        }

        return traversalResult;
    }

    private void buildPreOrder(Node<T> node, List<Node<T>> traversalResult) {
        traversalResult.add(node);

        for(Node<T> child : node.getChildren()) {
            buildPreOrder(child, traversalResult);
        }
    }

    private void buildPostOrder(Node<T> node, List<Node<T>> traversalResult) {
        for(Node<T> child : node.getChildren()) {
            buildPostOrder(child, traversalResult);
        }

        traversalResult.add(node);
    }

    public Map<Node<T>, Integer> buildWithDepth(TraversalOrder traversalOrder) {
        Map<Node<T>, Integer> returnMap = null;

        if(root != null) {
            returnMap = buildWithDepth(root, traversalOrder);
        }

        return returnMap;
    }

    public Map<Node<T>, Integer> buildWithDepth(Node<T> node, TraversalOrder traversalOrder) {
        Map<Node<T>, Integer> traversalResult = new LinkedHashMap<Node<T>, Integer>();

        if(traversalOrder == TraversalOrder.PRE_ORDER) {
            buildPreOrderWithDepth(node, traversalResult, 0);
        }

        else if(traversalOrder == TraversalOrder.POST_ORDER) {
            buildPostOrderWithDepth(node, traversalResult, 0);
        }

        return traversalResult;
    }

    private void buildPreOrderWithDepth(Node<T> node, Map<Node<T>, Integer> traversalResult, int depth) {
        traversalResult.put(node, depth);

        for(Node<T> child : node.getChildren()) {
            buildPreOrderWithDepth(child, traversalResult, depth + 1);
        }
    }

    private void buildPostOrderWithDepth(Node<T> node, Map<Node<T>, Integer> traversalResult, int depth) {
        for(Node<T> child : node.getChildren()) {
            buildPostOrderWithDepth(child, traversalResult, depth + 1);
        }

        traversalResult.put(node, depth);
    }

    public String toString() {
        String stringRepresentation = "";

        if(root != null) {
            stringRepresentation = build(TraversalOrder.PRE_ORDER).toString();
        }
        return stringRepresentation;
    }

    public String toStringWithDepth() {
        String stringRepresentation = "";

        if(root != null) {
            stringRepresentation = buildWithDepth(TraversalOrder.PRE_ORDER).toString();
        }

        return stringRepresentation;
    }
}
