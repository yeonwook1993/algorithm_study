import java.io.*;
import java.util.*;


public class Baek1152{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int count=0;
		while(st.hasMoreTokens()){
			st.nextToken();
			count++;
		}
		System.out.println(count);
	}
}