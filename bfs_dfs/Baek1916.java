import java.util.*;
class Edge {
	int end, cost;
	Edge(int end,int cost){
		this.end = end; this.cost = cost;
	}
}
class Baek1916{
	public static void main(String[] args) {
		final int INF = 987654321;

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] bus = new int[n+1][n+1];
		for(int i = 0; i <= n; i++){
			for(int j = 0; j <= n; j++){
				bus[i][j] = INF;
			}
		}

		for(int i = 0; i < m; i ++){
			int x = sc.nextInt();
			int y = sc.nextInt();
			int z = sc.nextInt();
			if (bus[x][y] > z) {
				bus[x][y] = z;
			}
		}
		
		int[] d = new int[n+1];
		boolean[] visit = new boolean[n+1];

		for(int i = 0; i<= n; i++){
			d[i] = INF;
			visit[i] = false;
		}
		int start = sc.nextInt();
		int end = sc.nextInt();
		d[start] = 0;
		visit[0] = true;

		for(int it = 0; it < n; it++){
			int min = INF;
			int point = -1;
			for(int i = 1; i <= n; i++){
				if(!visit[i] && d[i] <= min){
					point = i;
					min = d[i];
				}
			}
			if(point == -1){
				break;
			}
			visit[point] = true;
			
			for(int i = 1; i <= n; i++){
				if(d[i] > d[point] + bus[point][i])	d[i] = d[point] + bus[point][i];
			}
		}
		System.out.println(d[end]);
	}
}