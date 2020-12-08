import java.util.*;
import java.io.*;

public class Baek10844 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 1; i <= 9; i++) q.add(i);
	
		while(true) {
			int pop_int = q.poll();
			if(Integer.toString(pop_int).length() == N) {
				break;
			} else {
				if(pop_int == 0 || pop_int%10 == 0) {
					int input1 = (pop_int*10) + (pop_int + 1);
					q.add(input1);
				} else if(pop_int %10 == 9) {
					int input2 = (pop_int*10) - (pop_int - 1);
					q.add(input2);
				} else {
					int input1 = (pop_int*10) + (pop_int + 1);
					int input2 = (pop_int*10) - (pop_int - 1);
					q.add(input1);
					q.add(input2);
				}
			}
		}
		
		System.out.println(q.size()+1);
	}
}
