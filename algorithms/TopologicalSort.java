package Graph.algorithms;

import Graph.core.Edge;
import Graph.core.Graph;
import Graph.core.Vertex;

import java.util.*;

/**
 * Created by Nandkishore on 7/19/2015.
 * Topological sort is algorithm used to return a an order in which graph can be traversed when set of rules are defined.
 *
 * @order : Final list of vertices ordered in which the graph should be traversed.
 */

public class TopologicalSort {
    public List<Vertex> order;

    /**
     * This is the map of vertices with their incoming edges (kindof reverse graph)
     * @Key : each Vertex
     * @Value : List of all the incoming edges to given vertex
     */

    private Map<Vertex, List<Edge>> incomingEdgeMap;

    /**
     * Synoposis : Keep on adding vertices with no incoming edge and keep removing edges once traversed.
     * @param g Graph on which Topological sort to be implemented.
     *
     */
    TopologicalSort(Graph g) {
        this.order = new ArrayList<Vertex>();

        this.incomingEdgeMap = g.getIncomingEdgeMap();

        Queue<Vertex> queue = getNoIncomingVertex();
        while(!queue.isEmpty()) {
            Vertex v = queue.poll();
            this.order.add(v);

            for(Edge e : g.getAllEdgesForVertex(v)) {
                this.incomingEdgeMap.get(e.getTo()).remove(e);
                if(this.incomingEdgeMap.get(e.getTo()).isEmpty()) {
                    queue.add(e.getTo());
                }
            }
        }
    }

    /**
    Return list of all the vertices which has no incoming edge.
     */
    private Queue<Vertex> getNoIncomingVertex() {
        Queue<Vertex> queue = new LinkedList<Vertex>();

        for(Vertex v : this.incomingEdgeMap.keySet()) {
            if(this.incomingEdgeMap.get(v).isEmpty() && !this.order.contains(v)) {
                queue.add(v);
            }
        }
        return queue;
    }
}