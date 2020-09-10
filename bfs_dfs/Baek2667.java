import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Collections;

class Pair{
	private int x;
	private int y;

	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
	int left(){
		return this.x;
	}
	int right(){
		return this.y;
	}
}

class Baek2667{
	
	public static int bfs(int i, int j){
		Queue<Pair> q = new LinkedList<Pair>();
		Pair p = new Pair(i,j);
		int count = 1;
		visited[i][j] = false;

		q.offer(p);
		while(!q.isEmpty()){
			p = q.poll();
			int x = p.left();
			int y = p.right();
			visited[x][y]= false;

			Pair[] list = new Pair[4];
			list[0] = new Pair(x+1,y);
			list[1] = new Pair(x-1,y);
			list[2] = new Pair(x,y+1);
			list[3] = new Pair(x,y-1);

			for(Pair tmp : list){
				if(0<tmp.left()&& tmp.left() <=n && 
					0<tmp.right()&& tmp.right() <=n &&
					map[tmp.left()][tmp.right()] == 1&&
					visited[tmp.left()][tmp.right()]==true){
					q.add(tmp); visited[tmp.left()][tmp.right()]=false;
					count ++;
				}
			}
		}
	return count;
	}
	public static int[][] map;
	public static boolean[][] visited;
	public static int n;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		ArrayList<Integer> arr = new ArrayList<Integer>();
		map = new int[n+1][n+1];
		visited = new boolean[n+1][n+1];

		for(int i = 1; i <= n; i++){
			String line = br.readLine();
			for(int j = 1; j <= n; j++){
				map[i][j] = line.charAt(j-1) - '0';
				visited[i][j] = true;
			}
		}

		for(int i = 1; i<=n;i++){
			for(int j =1; j<=n;j++){
				if(map[i][j] == 1 && visited[i][j]){
					arr.add(bfs(i,j));
				}
			}
		}
		System.out.println(arr.size());
		Collections.sort(arr);
		for(int e : arr){
			System.out.println(e);
		}
	}
}