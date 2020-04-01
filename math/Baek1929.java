import java.io.*;
import java.util.*;

public class Baek1929 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int from = Integer.parseInt(st.nextToken());
		int to = Integer.parseInt(st.nextToken());
		boolean[] isPrime = new boolean[to+1];
		for(int i = 2; i <= to; i ++){
			int n = (int)Math.sqrt(i);
			boolean flag = true;
			for(int j = 2; j <= n; j++){
				if(i%j == 0){
					flag = false;
				}
			}
			if(flag)	isPrime[i] = true;
		}

		for(int i = from; i <= to; i++){
			if(isPrime[i])	System.out.println(i);
		}
	}
}