import java.util.*;
public class Baek11055{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] arr = new int[n+1];
		int[] dp = new int[n+1];

		for(int i = 1; i < n+1; i++){
			arr[i] = sc.nextInt();
			dp[i] = arr[i];
		}
		for(int i =2; i <n+1; i++){
			for(int j = 1; j<i; j++){
				if(arr[j] < arr[i] && dp[i] < dp[j] + arr[i]){
					dp[i] = dp[j] + arr[i];
				}
			}
		}
		Arrays.sort(dp);
		System.out.println(dp[n]);
	}
}