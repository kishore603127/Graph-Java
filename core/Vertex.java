package Graph.core;

import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * Represent the Vertex of a graph
 *
 * Created by Nandkishore on 7/15/2015.
 */
public class Vertex {

    /**
     * Value that this vertex holds, can be string, Int, or any custom object
     */
    private Object value;

    public void setValue(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    @Override
    public String toString() {
        return (String)this.getValue();
    }

    public Vertex(Object value) {
        this.value = value;
    }

    public Boolean equals(Vertex v) {
        return this.value.equals(v.value);
    }

    public Boolean equals(String s) {
        return this.value.equals(s);
    }
}
