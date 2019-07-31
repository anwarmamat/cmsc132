package graph;

import java.util.Stack;


public class Graph {
    private final int V;
    private int E;
    private Bag<Integer>[] adj;
    
    public Graph(int V) {
        if (V < 0) throw new IllegalArgumentException("Number of vertices must be nonnegative");
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
    }

    /**
     * Initializes a new graph that is a deep copy of <tt>G</tt>.
     * @param G the graph to copy
     */
    public Graph(Graph G) {
        this(G.V());
        this.E = G.E();
        for (int v = 0; v < G.V(); v++) {
            // reverse so that adjacency list is in same order as original
            Stack<Integer> reverse = new Stack<Integer>();
            for (int w : G.adj[v]) {
                reverse.push(w);
            }
            for (int w : reverse) {
                adj[v].add(w);
            }
        }
    }


    public int V() {
        return V;
    }


    public int E() {
        return E;
    }

    // throw an IndexOutOfBoundsException unless 0 <= v < V
    private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IndexOutOfBoundsException("vertex " + v + " is not between 0 and " + (V-1));
    }

    
    public void addEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        E++;
        adj[v].add(w);
        adj[w].add(v);
    }



    public Iterable<Integer> adj(int v) {
        validateVertex(v);
        return adj[v];
    }


    public int degree(int v) {
        validateVertex(v);
        return adj[v].size();
    }


    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " vertices, " + E + " edges " +"\n");
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (int w : adj[v]) {
                s.append(w + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }


    public static void main(String[] args) {
        //In in = new In(args[0]);
        Graph G = new Graph(4);
        G.addEdge(0, 1);
        G.addEdge(0, 2);
        G.addEdge(2, 3);
        G.addEdge(1,2);
        System.out.println(G);
        /*
        0-----1
        |   /
        |  /
        2-----3
        */
        
    }

}
