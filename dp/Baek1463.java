import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());
		int[] list = new int[1000001];
		list[2] = 1;
		if(x >= 3){
			list[3] = 1;	
		}
		

		for(int i = 4; i <= x; i++){
			if(i%2 == 0 && i%3 == 0){
				list[i] = Math.min(list[i-1]+1,Math.min(list[i/2]+1,list[i/3]+1));
			} else if(i%3 == 0){
				list[i] = Math.min(list[i/3] +1,list[i-1]+1);
			} else if (i%2 == 0){
				list[i] = Math.min(list[i/2] +1,list[i-1]+1);
			} else {
				list[i] = list[i-1] + 1;
			}
		}
		System.out.println(list[x]);
	}
}