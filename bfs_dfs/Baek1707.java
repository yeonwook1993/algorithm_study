import java.util.*;
class Baek1707{
	static boolean check(ArrayList<Integer>[] a, int[] group) {
		for(int i = 1; i < a.length; i++) {
			for(int e : a[i]) {
				if(group[e] == group[i] || group[e] == 0 || group[i] == 0) {
					return false;
				}
			}
		}
		return true;
	}
	static void bfs(ArrayList<Integer>[] a, int V, int[] group){
		boolean[] visit = new boolean[V+1];
		Stack<Integer> s = new Stack<>();
		for(int i = 1; i < a.length; i++){
			if(!visit[i]){
				s.push(i);
				group[i] = 1;
				while(!s.isEmpty()){
					int x = s.pop();
					visit[x] = true;
					for(int e : a[x]){
						if(group[e] == 0){
							group[e] = 3 - group[x];
							if(!visit[e]){
								s.push(e);
							}
						}
					}
				}
			}	
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		while(K-- > 0){
			int V = sc.nextInt();
			int E = sc.nextInt();
			ArrayList<Integer>[] a = new ArrayList[V+1];
			int[] group = new int[V+1];
			
			for(int i = 1; i <= V; i ++){
				a[i] = new ArrayList<>();
			}

			for(int i = 1; i <= E; i++){
				int x = sc.nextInt();
				int y = sc.nextInt();
				a[x].add(y);
				a[y].add(x);
			}
			bfs(a,V,group);
			// for(int i = 1; i < a.length; i++){
			// 	if(group[i] == 1){
			// 		System.out.println(i + " is red group");
			// 	}
			// 	if(group[i] == 2){
			// 		System.out.println(i + " is blue group");
			// 	}
			// }
			if(check(a,group)){
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}



//틀린 풀이
// import java.util.*;
// class Baek1707{
// 	static boolean check(ArrayList<Integer>[] a, int[] group) {
// 		for(int i = 1; i < a.length; i++) {
// 			for(int e : a[i]) {
// 				if(group[e] == group[i] || group[e] == 0 || group[i] == 0) {
// 					return false;
// 				}
// 			}
// 		}
// 		return true;
// 	}
// 	static void bfs(ArrayList<Integer>[] a, int V, int[] group){
// 		boolean[] visit = new boolean[V+1];
// 		Stack<Integer> s = new Stack<>();
// 		group[1] = 1;
// 		s.push(1);
// 		while(!s.isEmpty()){
// 			int x = s.pop();
// 			visit[x] = true;

// 			for(int e : a[x]){
// 				if(group[e] == 0){
// 					group[e] = 3 - group[x];
// 					if(!visit[e]){
// 						s.push(e);
// 					}
// 				}
// 			}
// 		}
// 	}
// 	public static void main(String[] args) {
// 		Scanner sc = new Scanner(System.in);
// 		int K = sc.nextInt();
// 		while(K-- > 0){
// 			int V = sc.nextInt();
// 			int E = sc.nextInt();
// 			ArrayList<Integer>[] a = new ArrayList[V+1];
// 			int[] group = new int[V+1];
			
// 			for(int i = 1; i <= V; i ++){
// 				a[i] = new ArrayList<>();
// 			}

// 			for(int i = 1; i <= E; i++){
// 				int x = sc.nextInt();
// 				int y = sc.nextInt();
// 				a[x].add(y);
// 				a[y].add(x);
// 			}
// 			bfs(a,V,group);
// 			if(check(a,group)){
// 				System.out.println("YES");
// 			} else {
// 				System.out.println("NO");
// 			}
// 		}
// 	}
// }