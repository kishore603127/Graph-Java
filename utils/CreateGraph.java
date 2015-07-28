package Graph.utils;

import Graph.core.Edge;
import Graph.core.Graph;
import Graph.core.Vertex;

/**
 * Created by Nandkishore on 7/15/2015.
 * This class creates a sample graph which can be used in executing different algorithms
 *
 *
 */
public class CreateGraph {
    private Graph graph;

    public Graph getGraph() {
        return this.graph;
    }

    /**
     *
     * @param isDirected : If set to true, directed graph will be created, else indrected graph will be created.
     */
    public CreateGraph(boolean isDirected) {
        Graph g = this.graph = new Graph(isDirected);

        Vertex A = new Vertex("A");
        Vertex B = new Vertex("B");
        Vertex C = new Vertex("C");
        Vertex D = new Vertex("D");
        Vertex E = new Vertex("E");
        Vertex F = new Vertex("F");
        Vertex G = new Vertex("G");
        Vertex H = new Vertex("H");

        g.addVertex(A);
        g.addVertex(B);
        g.addVertex(C);
        g.addVertex(D);
        g.addVertex(E);
        g.addVertex(F);
        g.addVertex(G);
        g.addVertex(H);

        g.addEdge(new Edge(A,B,1));
        g.addEdge(new Edge(A,C,2));
        //g.addEdge(new Edge(C,B,3));
        g.addEdge(new Edge(B,D,4));
        g.addEdge(new Edge(B,E,5));
        g.addEdge(new Edge(C,D,5));
        g.addEdge(new Edge(C,E,6));
        g.addEdge(new Edge(E,F,7));

    }
}
