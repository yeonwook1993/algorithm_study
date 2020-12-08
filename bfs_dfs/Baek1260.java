import java.util.*;

class Main{
	public static void bfs(int[][] a, boolean[] visit, int V){
		Queue<Integer> q = new LinkedList<>();
		q.offer(V);
		visit[V] = true;
		while(!q.isEmpty()){
			int x = q.poll();
			System.out.print(x+" ");
			for(int i = 1; i < a.length; i ++){
				if(a[x][i] == 1 && !visit[i]){
					visit[i] = true;
					q.offer(i);
				}
			}
		}
	}

	public static void dfs(int[][] a, boolean[] visit, int V){
		System.out.print(V+" ");
		visit[V] = true;
		for(int i = 1; i < a.length; i ++){
			if(a[V][i] == 1 && !visit[i]){
				dfs(a,visit,i);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//N = 정점, M = 간선, V = 탐색을 시작할 정점
		int N = sc.nextInt();
		int M = sc.nextInt();
		int V = sc.nextInt();

		int[][] a = new int[N+1][N+1];
		for(int i = 0; i < M; i ++){
			int x = sc.nextInt();
			int y = sc.nextInt();
			//간선은 양방향이므로
			a[x][y] = 1;
			a[y][x] = 1;
		}
		boolean[] visit1 = new boolean[N+1];
		boolean[] visit2 = new boolean[N+1];
		dfs(a,visit1,V);
		System.out.println();
		bfs(a,visit2,V);
	}
}