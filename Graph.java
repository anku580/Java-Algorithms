import java.util.LinkedList;

public class Graph {
    private int V;
    private int E;
    private LinkedList<Integer>[] adj;

    public Graph(int V) {
        this.V = V;
        this.E = 0;

        this.adj = new LinkedList[this.V];
        for(int i = 0; i < V; i++) {
            this.adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int d) {
        this.adj[s].add(d);
        this.adj[d].add(s);
        this.E++;
    }

    public LinkedList<Integer> adj(int v) {
        return this.adj[v];
    }

    public int V() {
        return this.V;
    }

    public int E() {
        return this.E;
    }
}