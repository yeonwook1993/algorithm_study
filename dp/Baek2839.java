import java.io.*;
import java.util.*;


public class Baek2839{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		// System.out.println(rec(n));
		System.out.println(dp(n));
	}
	public static int dp(int n){
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(3);list.add(5);
		int it = 1;
		while(list.get(0) < n){
			System.out.println(list);
			if(list.contains(new Integer(n))){
				return it;
			}
			int j = list.size();
			for(int i = 0; i < j; i++){
				list.add((list.get(0)+3));
				list.add((list.get(0)+5));
				list.remove(0);
			}
			TreeSet<Integer> tmp = new TreeSet<Integer>(list);
			list = new ArrayList<Integer>(tmp);
			it++;
		}
		if(list.contains(new Integer(n))){
			return it;
		} else {
			return -1;
		}
	}
	// public static int rec(int n){
	// 	int result = 0;
	// 	while(n > 0){
	// 		if(n%5 == 0){
	// 			return result + n/5;
	// 		} else {
	// 			n = n - 3;
	// 			result ++;
	// 		}
	// 	}
	// 	if(n < 0){
	// 		return -1;
	// 	} else {
	// 		return result;
	// 	}
	// }
}
