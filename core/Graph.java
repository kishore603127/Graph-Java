package Graph.core;

import java.util.*;

/**
 * Graph object where a graph is represented as a map with @Key as each vertex and @Value as all the outgoing Edges from that vertex.
 * Created by Nandkishore on 7/15/2015.
 */
public class Graph {

    /**
     * Graph representation with @Key as each vertex and @Value as all the outgoing Edges from that vertex.
     */
    Map<Vertex, List<Edge>> graphMap;

    /**
     * True : Directed Graph
     * False : UnDirected Graph
     */
    Boolean isDirected;

    public Graph() {
        this.graphMap = new HashMap<Vertex, List<Edge>>();
        this.isDirected = false;
    }
    public Graph(Boolean isDirected) {
        this.graphMap = new HashMap<Vertex, List<Edge>>();
        this.isDirected = isDirected;
    }

    /**
     * Method to add a vertex to the graph
     * @param v : Vertex to be added to the graph
     */
    public void addVertex(Vertex v) {
        this.graphMap.put(v, new ArrayList<Edge>());
    }

    /**
     * Method to add Edge to the graph
     * @param e : Edge to be added to the graph
     */
    public void addEdge(Edge e) {
        this.graphMap.get(e.getFrom()).add(e);
        if(!this.isDirected) {
            this.graphMap.get(e.getTo()).add(new Edge(e.getTo(), e.getFrom(), e.getValue()));
        }
    }

    /**
     * Method to get list of the outgoing edges of this vertex
     * @param v : Vertex for which to determine outgoing edges
     * @return : List of Edges which are originating from this vertex
     */

    public List<Edge> getAllEdgesForVertex(Vertex v) {
        if(v==null) {
            throw new NullPointerException("Null Vertex Occured.");
        }
        return this.graphMap.get(v);
    }

    /**
     * Get the edge between given source and destination
     * @param to : Destination Vertex
     * @param from : Source Vertex
     * @return Edge connecting source and destination
     */
    public Edge getEdgeBetweenVertex(Vertex to, Vertex from) {
        if(to==null || from==null) {
            throw new NullPointerException("Null Vertex Occured");
        }
        if(!this.graphMap.containsKey(to)) {
            throw new IllegalArgumentException("Vertex not part of graph : "+to);
        }

        if(!this.graphMap.containsKey(from)) {
            throw new IllegalArgumentException("Vertex not part of graph : "+from);
        }

        for(Edge E : this.graphMap.get(from)) {
            if(E.getTo().equals(to))
                return E;
        }
        return null;
    }

    /**
     * Determine if given vertex has any edge
     * @param to : Vertex for which to determine
     * @return True if vertex has outgoing edges. False if it doesn't
     */
    public boolean isVertexHasEdges(Vertex to) {
        if(to==null) {
            throw new NullPointerException("Null Vertex Occured.");
        }
        if(!this.hasVertex(to))
            return false;

        return this.getAllEdgesForVertex(to).size()>0;
    }

    /**
     * Determine if graph has this vertex
     * @param to : Vertex to be determine if its the part of the given graph
     * @return : True if this vertex is a part of this graph else False
     */
    public boolean hasVertex(Vertex to) {
        if(to==null) {
            throw new NullPointerException("Null Vertex Occured.");
        }
        return this.graphMap.containsKey(to);
    }

    /**
     * Method to get Vertex from the string value. (Only useful if vertex value is string)
     * @param s : String value to search for
     * @return Vertex with the given string as its value
     */
    public Vertex getVertex(String s) {
        if(s==null) {
            throw new NullPointerException("Null Can't be Name for a Vertex");
        }
        for(Vertex v : this.graphMap.keySet()) {
            if(v.equals(s)) {
                return v;
            }
        }
        return null;
    }

    /**
     *
     * @return All the vertices of the graph
     */
    public Set<Vertex> getAllVertices() {
        return this.graphMap.keySet();
    }

    /**
     * Returns a map with @Key as each vertex and @Value as the list of Edge that terminates at this Vertex (Kind of reverse Graph)
     * @return
     */
    public Map<Vertex, List<Edge>> getIncomingEdgeMap() {
        Map<Vertex, List<Edge>> edgeMap = new HashMap<Vertex, List<Edge>>();
        for(Vertex v : this.graphMap.keySet()) {
            if(!edgeMap.containsKey(v)) {
                edgeMap.put(v,new ArrayList<Edge>());
            }

            for(Edge e : this.getAllEdgesForVertex(v)) {
                List<Edge> edges;
                if(edgeMap.containsKey(e.getTo())) {
                    edges = edgeMap.get(e.getTo());
                }
                else {
                    edges = new ArrayList<Edge>();
                }
                edges.add(e);
                edgeMap.put(e.getTo(), edges);
            }
        }
        return edgeMap;
    }

    public Set<Vertex> getAllAdjacentVertices(Vertex v) {
        Set<Vertex> adjacentVertices = new HashSet<Vertex>();
        for(Edge e: this.getAllEdgesForVertex(v)) {
            adjacentVertices.add(e.getTo());
        }
        return adjacentVertices;
    }
    /**
     *
     * @param a source vertex
     * @param b destination vertex
     * @return True is there is a direct edge between a and b else False
     */
    public boolean isDirectEdge(Vertex a, Vertex b) {
        return this.getAllAdjacentVertices(a).contains(b);
    }

    /**
     * Source is the vertex of a directe graph which have no incoming edges
     * Commonly used for network flow problems
     * @return source vertex
     */
    public Vertex getSource() {
        Map<Vertex, List<Edge>> incomingEdgeMap = this.getIncomingEdgeMap();
        for(Vertex key : incomingEdgeMap.keySet()) {
            if(incomingEdgeMap.get(key).isEmpty())
                return key;
        }
        return null;
    }

    /**
     * Get All incoming edges for given vertex
     * @param v Source vertex
     * @return List of all the edges that are incoming
     */
    public List<Edge> getAllIncomingEdges(Vertex v) {
        if(v==null)
            throw new NullPointerException("Null Vertex Found");
        return this.getIncomingEdgeMap().get(v);
    }

    /**
     * Destination is the vertex of a directe graph which have no outgoing edges
     * Commonly used for network flow problems
     * @return destination vertex
     */
    public Vertex getDestination() {
        for(Vertex key : this.getAllVertices()) {
            if(this.getAllEdgesForVertex(key).isEmpty())
                return key;
        }
        return null;
    }

    /**
     * Prints the graph with each line representing Vertex and all the outgoing edges
     */

    public void print() {
        for(Vertex v : this.graphMap.keySet()) {
            System.out.print(v.getValue() + " -> ");
            for(Edge e : this.getAllEdgesForVertex(v)) {
                System.out.print(e.getTo().getValue() + " ( "+e.getValue() + " ) ");
            }
            System.out.println();
        }
    }
}