import java.util.*;
import java.io.*;

public class Baek11057 {
	public static int mod = 10007;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N+1][10];
		
		for(int i = 1; i <= N; i++) {
			for(int j = 0; j <= 9; j++) {
				if(i == 1) {
					dp[i][j] = 1;
				} else {
					for(int k = 0; k <= j; k++) {
						dp[i][j] = (dp[i][j] + dp[i-1][k])%mod;
					}
				}
			}
		}
		int ans = 0;
		for(int a : dp[N]) {
			ans = (ans +a)%mod;
		}
		System.out.println(ans);
		
	}
}
