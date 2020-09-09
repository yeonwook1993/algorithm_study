import java.util.Stack;
import java.util.Queue;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;



public class Baek1260 {
	public static void main(String[] args){
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int n,m,firstNode; int[][] map;


			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			firstNode = Integer.parseInt(st.nextToken());
			
			boolean[] visited = new boolean[n+1];
			boolean[] visited2 = new boolean[n+1];

			map = new int[n+1][n+1];


			Arrays.fill(visited,false);
			Arrays.fill(visited2,false);
			
			for(int i = 0; i < n+1; i++){
				Arrays.fill(map[i],0);	
			}
			

			for(int i = 0; i < m; i ++){
				st = new StringTokenizer(br.readLine()," ");
				int fromNode = Integer.parseInt(st.nextToken());
				int toNode = Integer.parseInt(st.nextToken());
				map[fromNode][toNode] = 1;
				map[toNode][fromNode] = 1;
			}
			
			Stack<Integer> stack = new Stack<Integer>();
			stack.push(firstNode);

			Queue<Integer> queue = new LinkedList<Integer>();
			queue.offer(firstNode);

			visited[firstNode] = true;
			visited2[firstNode] = true;

			dfs(map,visited,stack,n);
			System.out.print("\n");
			bfs(map,visited2,queue,n);


		} catch(IOException e){
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	private static void dfs(int[][] map, boolean[] visited, Stack<Integer> stack,int n){
		int from = stack.pop();
		System.out.print(from+" ");
		for (int to = 1; to < n+1;to++){
			if (map[from][to] == 1 && !visited[to]) {
				visited[to] = true;
				stack.push(to);
				dfs(map,visited,stack,n);
			}
		}
	}
	private static void bfs(int[][] map, boolean[] visited, Queue<Integer> queue, int n){
		while(queue.peek() != null){
			int from = queue.poll();
			System.out.print(from+" ");
			for(int i = 1; i < n+1; i ++){
				if(map[from][i] == 1 && !visited[i]) {
					queue.offer(i);
					visited[i] = true;
				}
			}	
		}
		
	}
}



