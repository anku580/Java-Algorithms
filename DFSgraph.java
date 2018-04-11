import java.util.LinkedList;
import java.util.Stack;

public class DFSgraph {

    private boolean[] marked;
    private int[] edgeTo;
    private int s;
    public Stack<Integer> stk = new Stack<>();

    DFSgraph(Graph g, int s) {
        marked = new boolean[g.V()];
        edgeTo = new int[g.V()];
        this.s = s;

        dfs(g, s);
    }

    public void dfs(Graph g, int v) {
        marked[v] = true;
        for (int w : g.adj(v)) {
            if (!marked[w]) {
                dfs(g, w);
                edgeTo[w] = v;
            }
        }
    }

    public void printEle(int d) {
        stk.push(d);
        do {
            stk.push(edgeTo[d]);
            d = edgeTo[d];
        } while (d != s);

        while (!stk.isEmpty()) {
            System.out.println(stk.pop());
        }

    }

    public static void main(String args[]) {
        Graph g = new Graph(7);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 5);
        g.addEdge(0, 6);
        g.addEdge(5, 3);
        g.addEdge(5, 4);
        g.addEdge(3, 4);
        g.addEdge(4, 6);

        DFSgraph d = new DFSgraph(g, 0);
        d.printEle(3);
    }
}