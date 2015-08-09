package Graph.core;

/**
 * Created by Nandkishore on 8/6/2015.
 */

/**
 * Edge for network flow problem
 * Its a edge with capacity and backCapacity (used) defined.
 */
public class NetworkEdge  extends Edge {
    private int capacity;
    private int backCapacity;

    public void setBackCapacity(int backCapacity) {
        this.backCapacity = backCapacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getBackCapacity() {
        return backCapacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public NetworkEdge(Vertex A, Vertex B) {
        super(A,B);
        this.setCapacity(0);
        this.setBackCapacity(0);
    }

    public NetworkEdge(Vertex A, Vertex B, int capacity) {
        super(A,B);
        this.setCapacity(capacity);
        this.setBackCapacity(0);
    }

    public NetworkEdge(Vertex A, Vertex B, int capacity, int backCapacity) {
        super(A,B);
        this.setCapacity(capacity);
        this.setBackCapacity(backCapacity);
    }
}

