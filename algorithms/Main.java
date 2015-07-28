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
        runBipartite();
    }

    private static void runBipartite() {
        Graph g = new CreateGraph(true).getGraph();
        print(new Bipartite(g).isPartite(g.getVertex("A")));
    }
    private static void runAllPaths() {
        Graph g = new CreateGraph(true).getGraph();
        print(g.isDirectEdge(g.getVertex("B"), g.getVertex("A")));
        print(new AllPaths(g, g.getVertex("C"), g.getVertex("B")).N);
    }
    private static void runFlyodWarshall() {
        Graph g = new CreateGraph(false).getGraph();
        FlyodWarshall fw = new FlyodWarshall(g);
        print(fw.vertices);
        fw.printSolution();
    }

    private static void runBFS() {
        Graph g = new CreateGraph(false).getGraph();
        print(new BFS(g, g.getVertex("A")).vertexSet);
    }

    private static void runDFS() {
        Graph g = new CreateGraph(false).getGraph();
        print(new DFS(g, g.getVertex("A")).vertexSet);
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
