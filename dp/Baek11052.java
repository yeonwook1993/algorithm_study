import java.util.*;
import java.io.*;

public class Baek11052 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] p = new int[n+1];
		int[] dp = new int[n+1];
		dp[0] = 0;

		String[] arr = (br.readLine()).split(" ");
		for(int i =1; i <= n; i++){
			p[i] = Integer.parseInt(arr[i-1]);
		}
		
		for(int i = 1; i<=n; i++){
			for(int j = i; j >= 0; j--){
				dp[i] = Math.max(dp[i],p[j]+dp[i-j]);
			}
		}
		System.out.println(dp[n]);
	}
}