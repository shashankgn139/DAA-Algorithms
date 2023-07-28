import java. util.*;
/*adjacency matrix Minimum Spannin Tree */

public class PrimMST {
	boolean visited[];
	boolean mstFlag[];
	int n;
	
	PrimMST(int n) {
		visited = new boolean[n];
		mstFlag = new boolean[n];
		this.n = n;
	}
	
	//edge class to hold the edge(v, u) and their weight
	class Edge {
		int v;
		int u;
		int wt;
		Edge (int v, int u, int wt) {
			this.v = v;
			this.u = u;
			this.wt = wt;
		}
	}
	
	/*2 edge lists, 
	one for the computation, use LinkedList (cuz ArrayList is manipulation heavy)
	one to hold the MST edges
	*/
	List<Edge> generalLst = new LinkedList<>();
	List<Edge> mstLst = new LinkedList<>();
	
	//function to add unvisited edges into a generalList
	void createList(int v, int graph[][]) {
		for(int i = 0; i < n; i++) {
			if(!visited[i] && graph[v][i] != 0) {
				Edge tmp = new Edge(v, i, graph[v][i]);
				generalLst.add(tmp);						//add unvisited vertices			
				//visited[i] = true;
			}
		}
	}
	
	//function to return the edge with the minimum weight in geleralLst
	//also set visited[] of the 'to' node to true
	Edge getMinWtEdge() {
		Edge min = generalLst.get(0); 
		for(Edge i : generalLst) {
			if(i.wt < min.wt) {
				min = i;
			}
		}
		// generalLst.remove(min);
		visited[min.u] = true;		//visited set to true
		return min;
	}

	//function to actually calculate the spanning tree
	//spanning tree function
	public void primMST(int graph[][]) {
		visited[0] = true;
		createList(0, graph);
		Edge tmp = getMinWtEdge();
		// System.out.println(tmp.wt);
		generalLst.remove(tmp);
		mstLst.add(tmp);
		for(int i = 1; i < n - 1; i++) {
			createList(tmp.u, graph);
			tmp = getMinWtEdge();
			generalLst.remove(tmp);
			mstLst.add(tmp);
		}
		
		System.out.println("mst edges: ");
		putList(mstLst);
		System.out.println("cost: " + getMinCost());
		System.out.println("-----------");
		System.out.println("remeining edges: ");
		putList(generalLst);
	}
	//function to print and calculate minimum cost and find the final list
	void putList(List<Edge> lst) {
		for(Edge i : lst) 
			System.out.print("(" + i.v + ", " + i.u + ")\n");
	}
	
	int getMinCost() {
		int cost = 0;
		for(Edge i : mstLst) 
			cost += i.wt;
		return cost;
	}
	
}
/*LinkedList function refernece
.get() - get element
.add() - add element to list
.remove() - remeove element from the list
.size()

for(Edge i : list) {
	
}
*/ 
