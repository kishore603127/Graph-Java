package Graph.algorithms;

import Graph.core.Edge;
import Graph.core.Graph;
import Graph.core.Vertex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Floyd warshall implementation using dynamic programming concept.
 * Created by Nandkishore on 7/23/2015.
 */
public class FlyodWarshall {
    public double[][] distance;
    private final double INF = 1.0/0.0;
    public List<Vertex> vertices;
    private int N;

    FlyodWarshall(Graph g) {
        initialize(g);
        for(int k=0;k<N;k++) {
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    distance[i][j] = Math.min(distance[i][j], distance[i][k]+distance[k][j]);
                }
            }
        }
    }

    public void printSolution() {
        for(int i=0;i<N;i++) {
            System.out.println(Arrays.toString(distance[i]));
        }
    }

    private void initialize(Graph g) {
        vertices = new ArrayList<Vertex>(g.getAllVertices());
        N = vertices.size();
        distance = new double[N][N];

        for(int i=0;i<N;i++) {
            Arrays.fill(distance[i], INF);
        }

        for(int i=0;i<N;i++) {
            distance[i][i]=0.0;
        }

        for(Vertex v : vertices) {
            for(Edge e : g.getAllEdgesForVertex(v)) {
                int i = vertices.indexOf(v);
                int j = vertices.indexOf(e.getTo());
                distance[i][j] = (double)e.getValue();
            }
        }
    }
}
