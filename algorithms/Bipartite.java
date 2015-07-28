package Graph.algorithms;

import Graph.core.Edge;
import Graph.core.Graph;
import Graph.core.Vertex;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created by Nandkishore on 7/27/2015.
 */
public class Bipartite {
    private Graph g;
    final private String RED="red";
    final private String BLUE="blue";
    private Map<Vertex, String> discoveryMap;

    Bipartite(Graph g) {
        this.g=g;
    }
    public boolean isPartite(Vertex s) {
        discoveryMap = new HashMap<Vertex, String>();

        Queue<Vertex> vertices = new LinkedList<Vertex>();

        vertices.add(s);

        discoveryMap.put(s, BLUE);

        while(!vertices.isEmpty()) {
            Vertex v = vertices.poll();
            System.out.println(v);
            for(Edge e : g.getAllEdgesForVertex(v)) {
                if(discoveryMap.containsKey(e.getTo())) {
                    if(discoveryMap.get(e.getTo()).equals(discoveryMap.get(v)))
                        return false;
                }
                else {
                    if (discoveryMap.get(v).equals(BLUE)) {
                        discoveryMap.put(e.getTo(), RED);
                    } else {
                        discoveryMap.put(e.getTo(), BLUE);
                    }
                    vertices.add(e.getTo());
                }
            }
        }
        return true;
    }
}
