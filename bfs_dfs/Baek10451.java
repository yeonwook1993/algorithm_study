import java.util.*;

class Baek10451{
	public static void dfs(int n, int[] arr, boolean[] visit){
		while(!visit[n]){
			visit[n] = true;
			n = arr[n];

		}
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		while(N-- > 0){
			int answer = 0;
			int it = sc.nextInt();
			int[] arr = new int[it+1];
			boolean[] visit = new boolean[it+1];
			for(int i = 1; i <= it; i++){
				arr[i] = sc.nextInt();
			}
			for(int i = 1; i <= it; i++){
				if(visit[i] == false){
					dfs(i,arr,visit);
					answer ++;
				}
			}
			System.out.println(answer);
		}
	}
}