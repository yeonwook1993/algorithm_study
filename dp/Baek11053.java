import java.util.*;
import java.io.*;

public class Baek11053 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n  = Integer.parseInt(br.readLine());
		String[] buf = br.readLine().split(" ");
		
		int[] list = new int[n+1];
		int[] dp = new int[n+1];
		
		
		for(int i = 1; i <= n; i++) {
			list[i] = Integer.parseInt(buf[i-1]);
			dp[i] = 1;
		}
		
		for(int i = 2; i <= n; i++) {
			for(int j = 1; j < i; j++) {
				if(list[j] < list[i] && dp[j] >= dp[i]) {
					dp[i] = dp[j]+1;
				}
			}
			
		}
		Arrays.sort(dp);
		System.out.println(dp[n]);
	}
}
