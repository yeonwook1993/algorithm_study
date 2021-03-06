import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

class Edge{
	int u,v,cost;

	Edge(int u, int v, int cost){
		this.u = u; this.v = v; this.cost = cost;
	}
}

class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int inf = 10000001;
		int n = sc.nextInt();
		int m = sc.nextInt();
		int dist[] = new int[n+1];
		boolean visited[] = new boolean[n+1];
		for(int i = 0; i < n+1; i++){
			dist[i] = inf;
			visited[i] = false;
		}

		ArrayList<Edge>[] bus = new ArrayList[n+1];
		for(int i = 1; i <= n; i++){
			bus[i] = new ArrayList<Edge>();
		}

		for(int i = 0; i < m; i++){
			int u = sc.nextInt();
			int v = sc.nextInt();
			int cost = sc.nextInt();
			bus[u].add(new Edge(u,v,cost));
		}

		int start = sc.nextInt();
		int end = sc.nextInt();
		dist[start] = 0;

		for(int k = 0; k < n-1; k++){
			int min = inf;
			int min_node = -1;
			for(int i = 1; i <= n; i ++){
				if(visited[i] == false && min >= dist[i]){
					min = dist[i];
					min_node = i;
				}
			}
			visited[min_node] = true;

			for(Edge y : bus[min_node]){
				if(dist[y.v] > dist[min_node] + y.cost){
					dist[y.v] = dist[min_node] + y.cost;
				}
			}
		}
		System.out.println(dist[end]);
	}
}