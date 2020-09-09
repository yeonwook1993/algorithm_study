import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek10844_2 {
	public static long mod = 1000000000L;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[][] dp = new long[N+1][10]; // N+1 -> depth, N+1 -> last_num
		dp[1][0] = 0;
		for(int i = 1; i <= 9; i++) {
			dp[1][i] = 1;
		}
		
		for(int i = 2; i <=N; i++) {
			for(int j = 0; j<=9; j++) {
				if(j == 0) {
					dp[i][j] = dp[i-1][j+1]%mod;
				} else if(j == 9) {
					dp[i][j] = dp[i-1][j-1]%mod;
				} else {
					dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1])%mod;
				}
			}
		}
		long answer = 0;
		for(long a : dp[N]) {
			answer = (answer + a)%mod;
		}
		System.out.println(answer);
		
	}	
}
	
