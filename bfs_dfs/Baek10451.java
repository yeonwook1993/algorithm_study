import java.io.BufferedReader;
import java.util.Stack;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;

public class Baek10451 {
	static boolean[] visited;

	public static int dfs(int[] map, int size) {
		int ans = 0;
		Stack<Integer> s = new Stack<Integer>();
		for (int i = 1; i <= size; i++) {
			if (!visited[i]) {
				s.add(i);
				visited[i] = true;
				while (!s.empty()) {
					int from = s.pop();
					int j = map[from];
					
					if (visited[j] || i==j) {
						ans ++;
						break;
					} else {
						visited[j] = true;
						s.add(j);
					}
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		while (n != 0) {
			int T = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] map = new int[T + 1];
			visited = new boolean[T + 1];
			Arrays.fill(visited, false);
			for (int i = 1; i <= T; i++) {
				int j = Integer.parseInt(st.nextToken());
				map[i] = j;
			}
			int result = dfs(map, T);
			System.out.println(result);
			n--;
		}
	}
}
