package Graph.algorithms;

import Graph.core.Edge;
import Graph.core.Graph;
import Graph.core.Vertex;

import java.util.*;

/**
 * Breadth First Search graph traversal
 *
 */
public class BFS {
    /**
     * Set of vertices that are reachable from source vertex.
     * @Suggestion : Map it list if you want to keep order of traversal
     */
    public Set<Vertex> vertexSet;
    private Map<Vertex, String> discoveryMap;

    private final String UNDISCOVERED = "Undiscoverd";
    private final String DISCOVERED = "Discoverd";

    /**
     *
     * @param g Given Graph
     * @param s Source Vertex
     */
    BFS(Graph g, Vertex s) {
        vertexSet = new HashSet<Vertex>();
        discoveryMap = new HashMap<Vertex, String>();

        Queue<Vertex> vertices = new LinkedList<Vertex>();
        vertices.add(s);
        discoveryMap.put(s, DISCOVERED);
        while(!vertices.isEmpty()) {
            Vertex v = vertices.poll();
            vertexSet.add(v);
            for(Edge e : g.getAllEdgesForVertex(v)) {
                if(!discoveryMap.containsKey(e.getTo())) {
                    discoveryMap.put(e.getTo(), DISCOVERED);
                    vertices.add(e.getTo());
                }
            }
        }
    }
}

