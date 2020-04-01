import java.io.*;
import java.util.*;
import java.lang.*;

public class Baek1978 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int totalPrime = 0;
		String [] arr = br.readLine().split(" ");
		for (int i = 0; i <n; i++){
			if(isPrime(Integer.parseInt(arr[i]))){
				totalPrime += 1;
			}
		}
		System.out.println(totalPrime);
	}
	private static boolean isPrime(int val){
		if (val == 1){
			return false;
		}
		double bound = Math.sqrt(val);
		for(int i = 2; i <= (int)bound; i++){
			if(val%i == 0){
				return false;
			}
		}
		return true;
	}
}