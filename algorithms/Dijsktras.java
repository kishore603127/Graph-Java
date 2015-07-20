package Graph.algorithms;

import Graph.core.Edge;
import Graph.core.Graph;
import Graph.core.Vertex;

import java.util.*;

/**
 * Dijsktras algorithm is implemented to find the shortest path.
 * Created by Nandkishore on 7/16/2015.
 */
public class Dijsktras {

    /**
     * Set of all the edges which are part of shortest path.
     */
    public HashSet<Edge> shortestEdgeSet;

    /**
     * Shortest distance of @key Vertex from starting Vertex.
     */
    public HashMap<Vertex, Integer> distanceMap;

    /**
     * Map to track the status of vertex.
     */
    private HashMap<Vertex, String> colored;

    /**
     * INFINITE : Largest distance possible
     */
    private final Integer INF = 9999999;

    /**
     * Represent that the vertex is not yet discovered.
     */
    private final String WHITE = "White";

    /**
     * Represent that the vertex is discovered.
     */
    private final String RED = "Red";

    /**
     * Represent that the vertex is Processed.
     */
    private final String BLACK = "Black";

    private Graph graph;

    /**
     *
     * @param g : Graph on which to implement Dijsktras
     */

    Dijsktras(Graph g) {
        shortestEdgeSet = new HashSet<Edge>();
        colored = new HashMap<Vertex, String>();
        this.graph = g;
        distanceMap = initialize();
    }

    /**
     *
     * @param A : Source or starting vertex
     * @param B : Destination or final vetex
     * @return the distance between source and destination
     */
    public int shortestPath(Vertex A, Vertex B) {
        Queue<Vertex> queue = new LinkedList<Vertex>();
        queue.add(A);
        colored.put(A,RED);
        distanceMap.put(A,0);
        while(!queue.isEmpty()) {
            Vertex v = queue.poll();
            colored.put(v,BLACK);
            int currentDistance = distanceMap.get(v);
            for(Edge e : graph.getAllEdgesForVertex(v)) {
                if(!colored.get(e.getTo()).equals(BLACK)) {
                    distanceMap.put(e.getTo(), Math.min(distanceMap.get(e.getTo()), currentDistance + e.getValue()));
                    queue.add(e.getTo());
                    colored.put(e.getTo(),BLACK);
                }
            }
            System.out.println(colored);
            System.out.println(distanceMap);
        }
        return distanceMap.get(B);
    }

    /**
     * Initialize Map such that each vertex is initially undiscovered.
     */
    private HashMap<Vertex, Integer> initialize() {
        HashMap<Vertex, Integer> map = new HashMap<Vertex, Integer>();
        Set<Vertex> vertices = this.graph.getAllVertices();
        for(Vertex v: vertices) {
            map.put(v, INF);
            this.colored.put(v, WHITE);
        }
        return map;
    }

}
