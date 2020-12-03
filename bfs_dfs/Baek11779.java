import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

class Edge{
	int u,v,cost;

	Edge(int u, int v, int cost){
		this.u = u; this.v = v; this.cost = cost;
	}
}

class Baek11779{
	public static int howMany(int start, int end, int[] where){
		int i = 1;
		int tmp = end;
		while(tmp != start){
			tmp = where[tmp];
			i++;
		}
		return i;
	}
	public static void print(int start, int end,int[] where){
		if(start == end){
			System.out.print(start + " ");
		} else {
			print(start,where[end],where);
			System.out.print(end + " ");
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int inf = 987654321;
		int n = sc.nextInt();
		int m = sc.nextInt();
		int dist[] = new int[n+1];
		int where[] = new int[n+1];
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
		visited[0] = true;

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
					where[y.v] = min_node;
				}
			}
		}
		System.out.println(dist[end]);
		System.out.println(howMany(start,end,where));
		print(start,end,where);
		System.out.println("");

	}
}