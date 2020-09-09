import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class Baek1707 {
	
	public static int[][] map;
	public static int[] group;
	
	
	public static void dfs(int start,int team,int size) {
		group[start] = team;
		for(int next = 1; next <= size; next++) {
			if(map[start][next] == 1) {
				if(group[next] == 0) {
					dfs(next, 3-team,size);	
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		
		for(int it = 1; it <= n; it++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken()); // 정점
			int e = Integer.parseInt(st.nextToken()); // 간선
			
			map = new int[v+1][v+1];
			group = new int[v+1];
			
			for(int i = 1; i <= e; i++) { // map 구현
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				map[start][end] = 1;
				map[end][start] = 1;
			}
			
			for(int i = 1; i <= v; i++) {
				for(int j = 1; j <= v; j++) {
					if(map[i][j] == 1 && group[j] == 0) {
						dfs(i,1,v);
					}
				}
			}
			boolean flag = true;
			for(int i = 1; i<=v; i++) {
				for(int j = 1; j <= map[i].length-1;j++) {
					if(group[i] == group[j] && i!=j && map[i][j] == 1) {
						flag = false;
					}
				}
			}
			if(flag) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}
