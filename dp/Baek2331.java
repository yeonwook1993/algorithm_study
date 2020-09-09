import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Stack;

public class Baek2331 {
	public static int nextVal(int A,int P) {
		int ans = 0;
		while(true) {
			if(A == 0) {
				return ans;
			} else {
				int val = A%10;
				ans += (int)Math.pow(val, P);
				A = A/10;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		int ans = 0;
		int board = 0;
		while(true) {
			list.add(A);
			int next = nextVal(A,P);
			if(list.contains(next)) {
				board = next;
				break;
			} else {
				A=next;
			}
			
		}
		
		while(true) {
			int tmp = list.remove(0);
			if(tmp == board)	break;
			else	ans++;
		}
		System.out.println(ans);
	}
}
