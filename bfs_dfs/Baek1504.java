import java.util.*;

class Baek1504{
	final static int INF = 100000000;
	static int[][] bus;
	static int n,m;

	// public static int dijk(int from,int to){
	// 	int[] d = new int[n+1];
	// 	boolean[] visit = new boolean[n+1];

	// 	for(int i = 1; i <= n; i++){
	// 		d[i] = INF;
	// 		visit[i] = false;
	// 	}

	// 	d[from] = 0;

	// 	for(int k = 0; k <= n; k++){
	// 		int min = INF;
	// 		int point = -1;

	// 		for(int i = 1; i <= n; i++){
	// 			if(!visit[i] && d[i] <= min){
	// 				point = i;
	// 				min = d[i];
	// 			}
	// 		}
	// 		if(point == -1){
	// 			break;
	// 		}
	// 		visit[point] = true;

	// 		for(int i = 1; i <= n; i++){
	// 			if(d[i] > d[point] + bus[point][i])	d[i] = d[point] + bus[point][i];
	// 		}
	// 	}

	// 	return d[to];

		
	// }
	private static int[] dijkstra(int start) {
        int[] d = new int[n+1];
        boolean[]c = new boolean[n+1];
        for (int i=1; i<=n; i++) {
            d[i] = INF;
            c[i] = false;
        }
        d[start] = 0;
        for (int k=0; k<n-1; k++) {
            int min = INF+1;
            int x = -1;
            for (int i=1; i<=n; i++) {
                if (c[i] == false && min > d[i]) {
                    min = d[i];
                    x = i;
                }
            }
            c[x] = true;
            for (int i=1; i<=n; i++) {
                if (d[i] > d[x] + bus[x][i]) {
                    d[i] = d[x] + bus[x][i];
                }
            }
        }
        return d;
    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		bus = new int[n+1][n+1];
		for(int i =1; i <= n; i++){
			for(int j = 1; j <= n; j++){
				bus[i][j] = INF;
			}
		}


		for(int i = 0; i < m; i++){
			int x = sc.nextInt();
			int y = sc.nextInt();
			int z = sc.nextInt();
			if(bus[x][y] > z){
				bus[x][y] = z;
				bus[y][x] = z;
			}
		}
		
		int v1 = sc.nextInt();
		int v2 = sc.nextInt();

		int[] dstart = dijkstra(1);
        int[] d1 = dijkstra(v1);
        int[] d2 = dijkstra(v2);
        int ans = dstart[v1] + d1[v2] + d2[n];
        int ans2 = dstart[v2] + d2[v1] + d1[n];
        if (ans > ans2) {
            ans = ans2;
        }
        if (ans >= INF) {
            ans = -1;
        }
        System.out.println(ans);
	}
}