package Graph.core;

/**
 * Represent the Edge between source and destination vertex
 * Created by Nandkishore on 7/15/2015.
 */
public class Edge {
    /**
     * Destination vertex
     */
    private Vertex to;
    /**
     * Source Vertex
     */
    private Vertex from;

    /**
     * Weight this edge holds
     */
    private int value;
    public Edge(Vertex from, Vertex to) {
        this.to = to;
        this.from = from;
        this.value = 1;
    }

    public Edge(Vertex from, Vertex to, int value) {
        this.to = to;
        this.from = from;
        this.value = value;
    }

    @Override
    public String toString() {
        return this.getFrom()+"->"+this.getTo()+" ("+this.getValue()+" )";
    }

    public Vertex getTo() {
        return this.to;
    }

    public Vertex getFrom() {
        return this.from;
    }

    public Integer getValue() {
        return this.value;
    }

    public Boolean equals(Edge e) {
        return (this.to==e.to && this.from==e.from && this.value==e.value);
    }
}
