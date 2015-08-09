package Graph.algorithms;

import Graph.core.Edge;
import Graph.core.Graph;
import Graph.core.NetworkEdge;
import Graph.core.Vertex;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Nandkishore on 8/6/2015.
 */
public class NetworkFlowGraph extends Graph {

    //private Map<Vertex, List<Edge>> incomingEdgeMap;

    public NetworkFlowGraph(boolean isDirected) {
        super(isDirected);
    }

    /**
     * This methods calculates all the valid edges or possible edges that can be a part of path from source to destination via v
     * @param v
     * @return
     */
    public List<NetworkEdge> getAllValidEdges(Vertex v) {
        List<NetworkEdge> edges = new ArrayList<NetworkEdge>();
        for(Edge e : this.getAllEdgesForVertex(v)) {
            NetworkEdge ne = (NetworkEdge) e;
            if(isValidForwardEdge(ne))
                edges.add(ne);
        }
        /*if(incomingEdgeMap==null) {
            incomingEdgeMap = this.getIncomingEdgeMap();
        }*/
        for(Edge e : this.getIncomingEdgeMap().get(v)) {
            NetworkEdge ne = (NetworkEdge) e;
            if(isValidBackwardEdge(ne))
                edges.add(ne);
        }
        return edges;
    }

    /**
     * An Forward Edge is valid is back capacity (capacity already used) is less than actual Edge capacity
     * @param e Given edge
     * @return True if Edge is valid else False
     */
    public boolean isValidForwardEdge(NetworkEdge e) {
        if(e==null)
            throw new NullPointerException("Null Edge found " + e);
        return e.getCapacity()-e.getBackCapacity() > 0;
    }

    /**
     * An Forward Edge is valid is back capacity (capacity already used) is less than actual Edge capacity
     * @param e Given edge
     * @return True if Edge is valid else False
     */
    public boolean isValidBackwardEdge(NetworkEdge e) {
        if(e==null)
            throw new NullPointerException("Null Edge found " + e);
        return e.getCapacity()-e.getBackCapacity() > 0;
    }
}
