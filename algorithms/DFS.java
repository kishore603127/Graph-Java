package Graph.algorithms;

import Graph.core.Edge;
import Graph.core.Graph;
import Graph.core.Vertex;

import java.util.*;

/**
 * Depth First Search graph traversal
 *
 */
public class DFS {
    /**
     * Set of vertices that are reachable from source vertex.
     */
    public List<Vertex> vertexSet;
    private Map<Vertex, String> discoveryMap;

    private final String UNDISCOVERED = "Undiscoverd";
    private final String DISCOVERED = "Discoverd";

    /**
     *
     * @param g Given Graph
     * @param s Source Vertex
     */
    DFS(Graph g, Vertex s) {
        vertexSet = new LinkedList<Vertex>();
        discoveryMap = new HashMap<Vertex, String>();

        Stack<Vertex> vertices = new Stack<Vertex>();
        vertices.add(s);
        discoveryMap.put(s, DISCOVERED);
        while(!vertices.isEmpty()) {
            Vertex v = vertices.pop();
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

