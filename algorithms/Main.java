package Graph.algorithms;

import Graph.core.Graph;
import Graph.utils.CreateGraph;

import java.util.Iterator;

/**
 * Demo of how to run those algorithms
 * Created by Nandkishore on 7/15/2015.
 */
public class Main {
    public static void main(String[] args) {
        runBFS();
    }

    private static void runBFS() {
        Graph g = new CreateGraph(false).getGraph();
        print(new BFS(g, g.getVertex("A")).vertexSet);
    }
    private void runTopologicalSort() {
        Graph g = new CreateGraph(true).getGraph();
        print(new TopologicalSort(g).order);
    }

    private void runDijsktras() {
        Graph g = new CreateGraph(false).getGraph();
        new Dijsktras(g).shortestPath(g.getVertex("A"), g.getVertex("B"));
    }
    private void runPrims() {
        Graph g = new CreateGraph(false).getGraph();
        Iterator it =  new PrimsMST(g).mstEdgeSet.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
    private void printGraph() {
        Graph g = new CreateGraph(false).getGraph();
        g.print();
    }

    private static void print(Object o) {
        System.out.println(o);
    }
}
