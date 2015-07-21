package Graph.algorithms;

import Graph.core.Edge;
import Graph.core.Graph;
import Graph.core.Vertex;

import java.util.*;

/**
 * Perform Prims algorithm to determine minimum spanning tree
 *
 * Created by Nandkishore on 7/17/2015.
 */
public class PrimsMST {
    public final HashSet<Edge> mstEdgeSet;

    /**
     * Maintain two different containers, one priority queue containing all the visited edges with priority based on its weight.
     * And another Set contains all the unvisited vertices.
     * @param g
     */
    PrimsMST(Graph g) {
        mstEdgeSet = new HashSet<Edge>();
        Set<Vertex> vertices = g.getAllVertices();

        PriorityQueue<Edge> queue = new PriorityQueue<Edge>(vertices.size(), new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        while(!vertices.isEmpty()) {

            Iterator<Vertex> it = vertices.iterator();

            Vertex start = it.next();
            queue.addAll(g.getAllEdgesForVertex(start));
            vertices.remove(start);

            while(!queue.isEmpty()) {

                Edge edge = queue.poll();
                Vertex to = edge.getTo();

                if (vertices.contains(to)) {
                    mstEdgeSet.add(edge);
                    queue.addAll(g.getAllEdgesForVertex(edge.getTo()));
                    System.out.println("Vertex remove : " + to.getValue());
                    vertices.remove(to);
                }
            }
        }
    }
}