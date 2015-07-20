package Graph.algorithms;

import Graph.core.Graph;
import Graph.utils.CreateGraph;

import java.util.Iterator;

/**
 * Created by Nandkishore on 7/15/2015.
 */
public class Main {
    public static void main(String[] args) {
        Graph g = new CreateGraph(true).getGraph();
        //g.print();
       // new BFS().traverse(g,g.getVertex("A"));
        /*System.out.println("Prims Edges set : ");
        Iterator it =  new PrimsMST(g).mstEdgeSet.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }*/
        //new Dijsktras(g).shortestPath(g.getVertex("A"), g.getVertex("B"));
        print(new TopologicalSort(g).order);

    }

    private static void print(Object o) {
        System.out.println(o);
    }
}
