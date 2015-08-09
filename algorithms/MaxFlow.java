package Graph.algorithms;

import Graph.core.Edge;
import Graph.core.Graph;
import Graph.core.NetworkEdge;
import Graph.core.Vertex;

import java.util.*;

/**
 * Created by Nandkishore on 7/22/2015.
 */
public class MaxFlow {
    public Graph g;
    private final String UNDISCOVERED = "Undiscoverd";
    private final String DISCOVERED = "Discoverd";

    public void maxFlow() {
        Vertex source = g.getSource();
        Vertex destination = g.getDestination();
    }

   private List<NetworkEdge> getPossiblePath(Vertex source, Vertex destination) {
       List<NetworkEdge> edges = new ArrayList<NetworkEdge>();
       Edge e = new NetworkEdge(source, destination);
       //edges = getAugmentingPath();
       return edges;
   }
    
    /*private List<NetworkEdge> getAugmentingPath(Vertex source, Vertex destination, List<NetworkEdge> edges) {
        if(source==destination)
            return edges;
        Stack<Vertex> vertices = new Stack<Vertex>();
        Map<Vertex, String> discoveryMap = new HashMap<Vertex, String>();

        vertices.add(source);
        discoveryMap.put(source, DISCOVERED);
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
        return edges;
    }
*/
}
