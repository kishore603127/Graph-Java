package Graph.algorithms;

import Graph.core.Edge;
import Graph.core.Graph;
import Graph.core.Path;
import Graph.core.Vertex;

import java.util.List;

/**
 * Created by Nandkishore on 7/23/2015.
 */
public class AllPaths {
    List<Path> allPaths;
    public int N=0;
    AllPaths(Graph g, Vertex s, Vertex d) {
        getAllPaths(g,s,d);
    }
    private int getAllPaths(Graph g, Vertex s, Vertex d) {
        if(s.equals(d))
            return 0;
        if(g.isDirectEdge(s, d))
            return 1;
        for(Edge e : g.getAllEdgesForVertex(s)) {
            this.N += getAllPaths(g,e.getTo(), d);
        }
        return this.N;
    }
}
