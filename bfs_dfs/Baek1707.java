import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Stack;

class Main{
	static ArrayList<Integer>[] map;
	static ArrayList<Integer>[] map2;
	static int[] group;

	public static void dfs(int start){
		Stack<Integer> s = new Stack<>();
		s.push(start);
		group[start] = 1;
		
		while(!s.empty()){
			int from = s.pop();
			while(map[from].size() != 0){
				int to = map[from].remove(0);
				map2[from].add(to);
				if(group[from] == 1){ // from == 1
					group[to] = 2;
					s.push(to);
				} else { // from == 2					
					group[to] = 1;
					s.push(to);
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(br.readLine());
		for(int it = 1; it <= test_case; it++){
			
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken()); // 정점
			int e = Integer.parseInt(st.nextToken()); // 간선
			group = new int[v+1];

			if(v==1){
				System.out.println("NO");
				continue;
			}

			map = (ArrayList<Integer>[])new ArrayList[v+1];
			map2 = (ArrayList<Integer>[])new ArrayList[v+1];
			for(int i = 1; i <= v;i++){
				map[i] = new ArrayList<Integer>();
				map2[i] = new ArrayList<Integer>();
			}
			for(int i = 1; i <= e; i++){
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				map[from].add(to);
			}
			boolean flag = true;
			
			for(int i = 1; i <= v; i++){
				int c = group[i];
				while(map2[i].size() > 0){
					int c2 = map2[i].remove(0);
					if(c == c2){
						flag = false;
					}
				}
			}




			if(flag){
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}		
	}
}

// 2
// 3 2
// 1 3
// 2 3
// 4 4
// 1 2
// 2 3
// 3 4
// 4 2