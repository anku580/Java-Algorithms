import java.util.LinkedList;
import java.util.Stack;

import sun.misc.Queue;

public class BFSgraph {

    private boolean[] marked;
    private int[] edgeTo;
    private int s;
    public Queue<Integer>que = new Queue<>();

    DFSgraph(Graph g, int s) {
        marked = new boolean[g.V()];
        edgeTo = new int[g.V()];
        this.s = s;

        bfs(g, s);
    }

    public void bfs(Graph g, int v) {
        que.push(v);
        
        while(que.isEmpty())
        {
            int vert = que.pop();
            marked[vert] = true;
            for(int w : g.adj(vert))
            {
                if(!marked[w]) {
                    que.push(w);
                    edgeTo[w] = v;
                }
            }
        }
    }

    public void printEle(int d) {
        int i = d;
        while(i != s) {
            System.out.println(i);
            i = edgeTo[i];
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

        BFSgraph d = new BFSgraph(g, 0);
        d.printEle(3);
    }
}