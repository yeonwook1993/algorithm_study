import java.io.IOException;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek11724 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n+1][n+1];
		boolean[] visited = new boolean[n+1];
		Arrays.fill(visited, false);
		
		
		for(int it = 1; it <= m; it++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			map[u][v] = 1;
			map[v][u] = 1;	
		}
		
		
	}
	static int dfs(int[][] map, boolean[] visited, int start, int size) {
		int answer = 0;
		Stack<Integer> s = new Stack<Integer>();
		s.add(start);
		
		while(!s.empty()) {
			int from = s.pop();
			for(int i = 1; i <=size; i++) {
				if(map[from][i] == 1 && visited[i] == false) {
					visited[i] = true;
				}
			}
		}
		
		return answer;
	}
}
