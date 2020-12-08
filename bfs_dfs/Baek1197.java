import java.util.Scanner;
import java.util.PriorityQueue;

class Edge implements Comparable<Edge> {
	int start;
	int end;
	int c;

	Edge() {
		this.start = 0;
		this.end = 0;
		this.c = 0;
	}

	Edge(int start, int end, int c) {
		this.start = start;
		this.end = end;
		this.c = c;
	}

	@Override
	public int compareTo(Edge e) {
		if (this.c > e.c) {
			return 1;
		} else {
			return -1;
		}
	}

}

public class Baek1197 {
	public static int find(int[] p, int x) {
		if (p[x] == x) {
			return x;
		} else {
			int y = find(p, p[x]);
			p[x] = y;
			return y;
		}
	}

	public static void union(int[] p, int x, int y) {
		x = find(p, x);
		y = find(p, y);
		p[y] = x;
	}

	public static boolean isSet(int[] p, int x, int y) {
		if (find(p, x) == find(p, y)) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();

		int[] p = new int[V + 1];
		for (int i = 0; i <= V; i++) {
			p[i] = i;
		}

		PriorityQueue<Edge> q = new PriorityQueue<>();
		int ans = 0;
		for (int i = 1; i <= E; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int c = sc.nextInt();
			q.add(new Edge(u, v, c));
		}

		while(!q.isEmpty()) { // 간선의 갯수는 V-1개
			Edge e = q.poll();
			if (isSet(p, e.start, e.end)) {
				continue;
			} else {
				union(p, e.start, e.end);
				ans += e.c;
			}
		}
		System.out.println(ans);
	}
}
