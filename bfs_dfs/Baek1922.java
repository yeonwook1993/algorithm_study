import java.util.Scanner;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.ArrayList;

class Edge implements Comparable<Edge> {
	int start;
	int end;
	int c;
	Edge(){
		this.start = 0;
		this.end = 0;
		this.c = 0;
	}
	Edge(int start, int end, int c){
		this.start = start;
		this.end = end;
		this.c = c;
	}
	@Override
	public int compareTo(Edge e) {
		if(this.c > e.c) {
			return 1;
		} else {
			return -1;
		}
	}
	
}
public class Baek1922 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		ArrayList<Edge>[] map = new ArrayList[n+1];
		
		for(int i = 1; i <=n; i ++) {
			map[i] = new ArrayList<Edge>();
		}

		HashSet<Integer> s = new HashSet<Integer>();
		

		for (int i = 1; i <= m; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int c = sc.nextInt();
			map[u].add(new Edge(u,v,c));
			map[v].add(new Edge(v,u,c));
		}
		
		PriorityQueue<Edge> q = new PriorityQueue<Edge>();
		int ans = 0;
		s.add(1);
		for(Edge e: map[1]) {
			q.add(e);
		}
		while(s.size() < n) {
			Edge e = new Edge();
			while(!q.isEmpty()) {
				e = q.poll();
				if(!s.contains(e.end)) {
					break;
				}
			}
			s.add(e.end);
			ans += e.c;
			for(Edge e2 : map[e.end]) {
				q.add(e2);
			}
		}
		
		
		System.out.println(ans);
	}
}
