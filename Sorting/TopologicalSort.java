import java.lang.*;
import java.io.*;
import java.util.*;

class TopologicalSort {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = read.readLine().trim().split("\\s+");
            int edg = Integer.parseInt(st[0]);
            int nov = Integer.parseInt(st[1]);

            for (int i = 0; i < nov + 1; i++)
                list.add(i, new ArrayList<Integer>());

            String s[] = read.readLine().trim().split("\\s+");
            int p = 0;
            for (int i = 1; i <= edg; i++) {
                int u = Integer.parseInt(s[p++]);
                int v = Integer.parseInt(s[p++]);
                list.get(u).add(v);
            }

            int[] res = new TopologicalSortUtil().topoSort(list, nov);

            if (check(list, nov, res) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
    static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {
        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res[i]] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : list.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}

class TopologicalSortUtil {
    static int[] topoSort(ArrayList<ArrayList<Integer>> adj, int N) {
        int[] indegree = new int[N];
        for(int i=0; i<N; i++) {
            ArrayList<Integer> temp = adj.get(i);
            for(int node : temp) {
                indegree[node]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<N; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }
        int visited = 0;
        ArrayList<Integer> result = new ArrayList<>();
        while(!q.isEmpty()) {
            int u = q.poll();
            result.add(u);
            for(int node : adj.get(u)) {
                if(--indegree[node] == 0) {
                    q.add(node);
                }
            }
            visited++;
        }
        int[] arr = new int[result.size()];
        for(int i=0; i<result.size(); i++) {
            arr[i] = result.get(i);
        }
        return arr;
    }
}
