import java.util.*;



class Baek11724 {
	public static boolean check(boolean[] visited){
		for(boolean b : visited){
			if(b == false){
				return false;
			}
		}
		return true;
	}

	public static void dfs(ArrayList<Integer>[] map, boolean[] visited, int start){
		int ans = 0;
		Stack<Integer> s = new Stack<>();
		s.push(start);
		while(!s.empty()){
			int from = s.pop();
			visited[from] = true;
			while(map[from].size() != 0){
				int to = map[from].remove(0);
				s.push(to);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		ArrayList<Integer>[] map = (ArrayList<Integer>[]) new ArrayList[n+1];
		for(int i= 1; i <= n; i++){
			map[i]	= new ArrayList<Integer>();
		}
		boolean[] visited = new boolean[n+1];
		Arrays.fill(visited,false);


		for(int i = 1; i <= m; i ++){
			int u = sc.nextInt();
			int v = sc.nextInt();
			map[u].add(v);
			map[v].add(u);
		}
		int ans = 0;

		for(int i = 1; i <= n; i ++){
			if(!visited[i]){
				dfs(map,visited,i);
				ans ++;
			}
		}
		System.out.println(ans);
	}
}