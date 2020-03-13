import java.util.*;
import java.io.*;


class Baek2178 {
	static int n,m;
	public static void main(String[] args) {
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine()," ");

			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			char[][] map = new char[n+1][m+1];
			boolean[][] visited = new boolean[n+1][m+1];

			for (int i = 0; i < n; i ++){
				String line = br.readLine();
				for(int j = 0; j < m; j++){
					map[i+1][j+1] = line.charAt(j);
				}
			}
			bfs(map,visited,1,1,1);
		}	
		catch (Exception e){
			e.printStackTrace();
		}
	}

	private static void bfs(char[][] map, boolean[][] visited,int stage,int x, int y){
		Queue<int[]> q = new LinkedList<int[]>();
		int[] start = {x,y,stage};
		q.offer(start);
		while(q.peek() != null){
			int[] cur = q.poll();
			if (cur[0] == n && cur[1] == m) {
				System.out.println(cur[2]);
				break;
			} else {
				int[][] canGo = {{cur[0],cur[1]+1},{cur[0],cur[1]-1},{cur[0]-1,cur[1]},{cur[0]+1,cur[1]}};
				for(int[] e : canGo){
					if(0<=e[0] && e[0]<=n && 0<=e[1] && e[1]<=m){
						if(map[e[0]][e[1]] == '1' && !visited[e[0]][e[1]]) {
							visited[e[0]][e[1]] = true;
							int[] next = {e[0],e[1],cur[2]+1};
							q.offer(next);
						}
					}
				}	
			}
		}
	}
}

// 가장 짧은 길 -> BFS 이용
