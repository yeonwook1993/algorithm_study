import java.io.*;
import java.util.*;

public class Baek2193 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[][] dp = new long[N+1][2];
		dp[1][0] = 0;
		dp[1][1] = 1;
		
		for(int i = 2; i <= N; i++) {
			dp[i][0] = dp[i-1][0] + dp[i-1][1];
			dp[i][1] = dp[i-1][0];
		}
		long ans = 0;
		for(long a : dp[N]) {
			ans = ans + a;
		}
		System.out.println(ans);
	}
}
