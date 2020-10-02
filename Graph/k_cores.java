// Java program to find K-Cores of a graph 
import java.util.*; 

class k_cores 
{ 

	// This class represents a undirected graph using adjacency 
	// list representation 
	static class Graph 
	{ 
		int V; // No. of vertices 

		// Pointer to an array containing adjacency lists 
		Vector<Integer>[] adj; 

		@SuppressWarnings("unchecked") 
		Graph(int V) 
		{ 
			this.V = V; 
			this.adj = new Vector[V]; 

			for (int i = 0; i < V; i++) 
				adj[i] = new Vector<>(); 
		} 

		// function to add an edge to graph 
		void addEdge(int u, int v) 
		{ 
			this.adj[u].add(v); 
			this.adj[v].add(u); 
		} 

		// A recursive function to print DFS starting from v. 
		// It returns true if degree of v after processing is less 
		// than k else false 
		// It also updates degree of adjacent if degree of v 
		// is less than k. And if degree of a processed adjacent 
		// becomes less than k, then it reduces of degree of v also, 
		boolean DFSUtil(int v, boolean[] visited, int[] vDegree, int k) 
		{ 

			// Mark the current node as visited and print it 
			visited[v] = true; 

			// Recur for all the vertices adjacent to this vertex 
			for (int i : adj[v]) 
			{ 

				// degree of v is less than k, then degree of adjacent 
				// must be reduced 
				if (vDegree[v] < k) 
					vDegree[i]--; 

				// If adjacent is not processed, process it 
				if (!visited[i]) 
				{ 

					// If degree of adjacent after processing becomes 
					// less than k, then reduce degree of v also. 
					if (DFSUtil(i, visited, vDegree, k)) 
						vDegree[v]--; 
				} 
			} 

			// Return true if degree of v is less than k 
			return (vDegree[v] < k); 
		} 

		// Prints k cores of an undirected graph 
		void printKCores(int k) 
		{ 

			// INITIALIZATION 
			// Mark all the vertices as not visited and not 
			// processed. 
			boolean[] visited = new boolean[V]; 
			boolean[] processed = new boolean[V]; 
			Arrays.fill(visited, false); 
			Arrays.fill(processed, false); 

			int mindeg = Integer.MAX_VALUE; 
			int startvertex = 0; 

			// Store degrees of all vertices 
			int[] vDegree = new int[V]; 
			for (int i = 0; i < V; i++) 
			{ 
				vDegree[i] = adj[i].size(); 

				if (vDegree[i] < mindeg) 
				{ 
					mindeg = vDegree[i]; 
					startvertex = i; 
				} 
			} 
			DFSUtil(startvertex, visited, vDegree, k); 

			// DFS traversal to update degrees of all 
			// vertices. 
			for (int i = 0; i < V; i++) 
				if (!visited[i]) 
					DFSUtil(i, visited, vDegree, k); 

			// PRINTING K CORES 
			System.out.println("K-Cores : "); 
			for (int v = 0; v < V; v++) 
			{ 

				// Only considering those vertices which have degree 
				// >= K after BFS 
				if (vDegree[v] >= k) 
				{ 
					System.out.printf("\n[%d]", v); 

					// Traverse adjacency list of v and print only 
					// those adjacent which have vDegree >= k after 
					// BFS. 
					for (int i : adj[v]) 
						if (vDegree[i] >= k) 
							System.out.printf(" -> %d", i); 
				} 
			} 
		} 
	} 

	// Driver Code 
	public static void main(String[] args) 
	{ 

		// Create a graph given in the above diagram 
		int k = 3; 
		Graph g1 = new Graph(9); 
		g1.addEdge(0, 1); 
		g1.addEdge(0, 2); 
		g1.addEdge(1, 2); 
		g1.addEdge(1, 5); 
		g1.addEdge(2, 3); 
		g1.addEdge(2, 4); 
		g1.addEdge(2, 5); 
		g1.addEdge(2, 6); 
		g1.addEdge(3, 4); 
		g1.addEdge(3, 6); 
		g1.addEdge(3, 7); 
		g1.addEdge(4, 6); 
		g1.addEdge(4, 7); 
		g1.addEdge(5, 6); 
		g1.addEdge(5, 8); 
		g1.addEdge(6, 7); 
		g1.addEdge(6, 8); 
		g1.printKCores(k); 

		System.out.println(); 

		Graph g2 = new Graph(13); 
		g2.addEdge(0, 1); 
		g2.addEdge(0, 2); 
		g2.addEdge(0, 3); 
		g2.addEdge(1, 4); 
		g2.addEdge(1, 5); 
		g2.addEdge(1, 6); 
		g2.addEdge(2, 7); 
		g2.addEdge(2, 8); 
		g2.addEdge(2, 9); 
		g2.addEdge(3, 10); 
		g2.addEdge(3, 11); 
		g2.addEdge(3, 12); 
		g2.printKCores(k); 
	} 
} 

