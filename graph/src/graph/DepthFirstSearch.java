package graph;

public class DepthFirstSearch {
    private boolean[] marked;    // marked[v] = is there an s-v path?
    private int count;           // number of vertices connected to s


    public DepthFirstSearch(Graph G, int s) {
        marked = new boolean[G.V()];
        dfs(G, s);
        
    }

    // depth first search from v
    private void dfs(Graph G, int v) {
        //count++;
        System.out.print(v+",");
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }


    public boolean marked(int v) {
        return marked[v];
    }

    public int count() {
        return count;
    }

    /**
     * Unit tests the <tt>DepthFirstSearch</tt> data type.
     */
    public static void main(String[] args) {
        /*
         *   (0) -----------(2)               /(6)
         *    |              |  \            /  |
         *    |              |    \         /   |
         *    |              |     (4)----(5)   |
         *    |	             |    /         \   |
         *    |              |   /           \  |
         *   (1)------------(3) /             \(7)
         *  
         *  0,2,4,5,7,6,3,1,
         *  
         *  // (9)-----(10)
         */
    	//Depth First Search:
    	//	0,2,4,5,7,6,3,1,

        Graph G = new Graph(10);
        //G.addEdge(8, 9);
        G.addEdge(0, 1);
        G.addEdge(0, 2);
        G.addEdge(1,3);
        G.addEdge(2, 3);
        G.addEdge(2, 4);
        G.addEdge(3, 4);
        G.addEdge(4, 5);
        G.addEdge(5, 6);
        G.addEdge(5, 7);
        G.addEdge(6, 7);
        System.out.println(G);
        int s = 0;
        System.out.println("Depth First Search:");
        DepthFirstSearch search = new DepthFirstSearch(G, s);
       /* 
        System.out.println("\nConnected vertices:");
        
        for (int v = 0; v < G.V(); v++) {
            if (search.marked(v))
                System.out.print(v + " ");
        }

        System.out.println();
        if (search.count() != G.V()) System.out.println("NOT connected");
        else                         System.out.println("connected");*/
    }

}
