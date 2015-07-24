package Graph.core;

import java.util.ArrayList;
import java.util.List;

/**
 * A Path is a collection of edges with end of one edge will be start of another edge
 * where source of first edge is the start of path
 * and end of last edge is destination.
 * Created by Nandkishore on 7/23/2015.
 */
public class Path {
    private List<Edge> edgeList;

    Path() {
        this.edgeList = new ArrayList<Edge>();
    }
    Path(Edge e) {
        this.edgeList = new ArrayList<Edge>();
        this.edgeList.add(e);
    }
    public void addEdge(Edge e) {
        this.edgeList.add(e);
    }
    public List<Edge> getEdgeSet() {
        return this.edgeList;
    }
}
