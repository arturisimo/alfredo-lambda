package org.apz.tree;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * N-ary node
 *
 * @param <T>
 */
public class Node<T> {

    private T data;
    private Set<Node<T>> children;
    private Node<T> parent;

    public Node() {
        super();
        children = new HashSet<Node<T>>();
    }

    public Node(T data) {
        this();
        this.data = data;
    }

    public Node<T> getParent() {
        return this.parent;
    }

    public Set<Node<T>> getChildren() {
        return this.children;
    }

    public int getNumberOfChildren() {
        return getChildren().size();
    }

    public boolean hasChildren() {
        return (getNumberOfChildren() > 0);
    }

    public void setChildren(Set<Node<T>> children) {
        for(Node<T> child : children) {
           child.parent = this;
        }

        this.children = children;
    }

    public void addChild(Node<T> child) {
        child.parent = this;
        children.add(child);
    }

    public void removeChildren() {
        this.children = new HashSet<>();
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String toString() {
        return getData().toString();
    }

    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
           return true;
        }
        if (obj == null) {
           return false;
        }
        if (getClass() != obj.getClass()) {
           return false;
        }
        Node<?> other = (Node<?>) obj;
        if (data == null) {
           if (other.data != null) {
              return false;
           }
        } else if (!data.equals(other.data)) {
           return false;
        }
        return true;
    }

    /* (non-Javadoc)
    * @see java.lang.Object#hashCode()
    */
    @Override
    public int hashCode() {
       final int prime = 31;
       int result = 1;
       result = prime * result + ((data == null) ? 0 : data.hashCode());
       return result;
    }
    
    public String toStringVerbose() {
    	return toStringVerbose(this);
    }
    
    public String toStringVerbose(Node<T> node) {
        StringBuilder sb = new StringBuilder(node.getData().toString());
        
        if (node.getChildren().isEmpty())
        	return sb.toString();
        
        sb.append(":[");
        
        for (Node<T> child : node.getChildren()) {
            sb.append(toStringVerbose(child)).append(", ");
        }
        
        String s = sb.toString();
        
        //Pattern.DOTALL causes ^ and $ to match. Otherwise it won't. It's retarded.
        Pattern pattern = Pattern.compile(", $", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(s);

        s = matcher.replaceFirst("");
        s += "]";
        return s;
    }
    
}