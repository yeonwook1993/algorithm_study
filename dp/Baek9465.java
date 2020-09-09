import java.util.*;
import java.io.*;


public class Baek9465 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		
		for(int i = 0; i < N; i++) {
			int max_val = 0;
			int col = Integer.parseInt(br.readLine());
			String[][] sticker = new String[2][col];
			for(int j = 0; j < 2; j++) {
				sticker[j] = br.readLine().split(" ");
			}
			int dp[][] = new int[2][col];
			dp[0][0] = Integer.parseInt(sticker[0][0]);
			dp[1][0] = Integer.parseInt(sticker[1][0]);
			dp[0][1] = Math.max(dp[1][0]+Integer.parseInt(sticker[0][1]), dp[0][0]);
			dp[1][1] = Math.max(dp[0][0]+Integer.parseInt(sticker[1][1]), dp[1][0]);
			
			for(int num = 2; num < col; num++) {
				dp[0][num] = Math.max(Math.max(dp[0][num-2], dp[1][num-2]) + Integer.parseInt(sticker[0][num]) ,dp[1][num-1]+Integer.parseInt(sticker[0][num]));
				dp[1][num] = Math.max(Math.max(dp[0][num-2], dp[1][num-2]) + Integer.parseInt(sticker[1][num]) ,dp[0][num-1]+Integer.parseInt(sticker[1][num]));
			}
			max_val = Math.max(dp[0][col-1],dp[1][col-1]);
			System.out.println(max_val);
		}
	}
}