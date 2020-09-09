import java.util.*;
import java.io.*;

public class Baek2156 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] glass = new int[n + 1];
		int[] dp = new int[n + 1];

		// initialize glass
		for (int i = 1; i <= n; i++) {
			glass[i] = Integer.parseInt(br.readLine());
		}
		if (n == 1) {
			System.out.println(glass[1]);
		} else if (n == 2) {
			System.out.println(glass[1] + glass[2]);
		} else {
			dp[0] = 0;
			dp[1] = glass[1];
			dp[2] = glass[2] + glass[1];
			for (int j = 3; j <= n; j++) {
				dp[j] = Math.max(dp[j - 2] + glass[j], Math.max(dp[j - 1], dp[j - 3] + glass[j - 1] + glass[j]));
			}

			System.out.println(dp[n]);
		}

	}
}
