import java.util.Scanner;

public class Baek1717 {
	public static int find(int[] p, int x) {
		if(x == p[x]) { //root �ϰ��
			return x;
		} else {
			int y = find(p,p[x]);  //root�� �ƴѰ�� root�� ã�� ���� ��͹����� y���� root���� ȣ��
			p[x] = y;              //
			return y;
		}
	}
	public static void union(int[] p, int x, int y) {
		x = find(p,x);
		y = find(p,y);
		p[y] = x;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int [] p = new int[n+1];
		
		for(int i = 0; i <= n; i++) {
			p[i] = i;
		}
		
		
		for(int i = 0; i < m; i++) {
			int op = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			if(op == 0) {
				union(p,x,y);
			} else {
				int a = find(p,x);
				int b = find(p,y);
				if( a== b) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		}
	}
}
