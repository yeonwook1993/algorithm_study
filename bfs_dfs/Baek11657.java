import java.util.Scanner;
import java.util.ArrayList;

class Edge{
	int x;
	int y;
	int cost;

	Edge(int x, int y, int cost){
		this.x = x;
		this.y = y;
		this.cost = cost;
	}
}

class Baek11657{
	private static final int INF = 500 * 100_000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int dist[] = new int[n+1];
		Edge bus[] = new Edge[m];
		ArrayList<Edge> list = new ArrayList<Edge>();

		for(int i = 0; i < m; i++){
			int u = sc.nextInt();
			int v = sc.nextInt();
			int c = sc.nextInt();
			bus[i] = new Edge(u,v,c);
		}
		
		for(int i = 1 ; i <= n; i++) dist[i] = INF;

		boolean flag = false;
		dist[1] = 0;
		for(int i = 1; i <= n; i++){
			for(int j = 0; j < m; j++){
				int x = bus[j].x;
				int y = bus[j].y;
				int c = bus[j].cost;

				if(dist[x] != INF && dist[y] > dist[x] +c){
					dist[y] = dist[x] + c;
					if(i == n){
						flag = true;
					}
				}
			}
		}
		if(!flag){
			for(int i = 2; i <= n; i++){
				if(dist[i] == inf) dist[i] = -1;
				System.out.println(dist[i]);
			}
        // 음의 cycle이 있는 경우
		}else{
			System.out.println("-1");
		}
	}
}

