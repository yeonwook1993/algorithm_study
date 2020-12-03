import java.util.Scanner;
class Hole{
	int s, e, t;
	Hole(int s, int e, int t){
		this.s = s;
		this.e = e;
		this.t = t;

	}
}


class Baek1865 {
	static final int INF = 1000000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int it = sc.nextInt();
		while(it-- > 0){
			int n = sc.nextInt();  // 지점의 수
			int m = sc.nextInt();  // 도로의 수
			int w = sc.nextInt();  // 웜홀의 수
			Hole[] hole_arr = new Hole[2*m+w];
			int[] dist = new int[n+1];
			for(int i = 1; i <= n; i++){
				dist[i] = INF;
			}
			for(int i = 0; i < 2*m; i=i+2){
				int s = sc.nextInt();
				int e = sc.nextInt();
				int t = sc.nextInt();
				hole_arr[i] = new Hole(s,e,t);
				hole_arr[i+1] = new Hole(e,s,t);
			}

			dist[1] = 0;
			for(int i = 0; i < w; i++){
				int s = sc.nextInt();
				int e = sc.nextInt();
				int t = sc.nextInt();
				hole_arr[2*m+i] = new Hole(s,e,-t);
			}
			//relax
			boolean flag = false;
			for(int i = 1; i <= n; i++){
				for(Hole h : hole_arr){
					int from = h.s;
					int to = h.e;
					int cost = h.t;
					
					if(dist[from] != INF && dist[to] > dist[from] + cost){	
						dist[to] = dist[from] + cost;
						if(i == n){
							flag = true;
						}
					}
				}
			}

			if(flag){
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}