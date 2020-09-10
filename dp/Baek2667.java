import java.util.Scanner;
import java.util.StringTokenizer;

class Baek2667{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] map = new int[n+1][n+1];
		boolean[][] visited = new boolean visited[n+1][n+1];
		Array.fills(visited,false);

		for(int i = 1; i <= n; i++){
			for(int j = 1; j <= n; j++){
				map[i][j] = sc.nextInt();
			}
		}


	}
}