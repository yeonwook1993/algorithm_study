	import java.io.BufferedReader;
	import java.io.InputStreamReader;
	import java.io.IOException;
	import java.util.StringTokenizer;
	import java.util.Queue;
	import java.util.LinkedList;

	class Pair{
		private int x;
		private int y;

		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
		int left(){
			return this.x;
		}
		int right(){
			return this.y;
		}
	}
	
	class Baek2146{
		public static int[][] map;
		public static int[][] group;
		public static int n;
		public static Queue<Pair> q;
		
		//다리놓기
		public static void make_bridge(){
			int[] di = {0,0,-1,1};
			int[] dj = {1,-1,0,0};
			q = new LinkedList<Pair>();
			for(int i = 1; i <= n; i++){
				for(int j = 1; j <= n; j++){
					if(map[i][j] == 1){
						q.offer(new Pair(i,j));
					}
				}
			}
			while(!q.isEmpty()){
				Pair p = q.poll();
				int i = p.left();
				int j = p.right();
				for(int k = 0; k <4; k++){
					int ni = i + di[k];
					int nj = j + dj[k];
					if(0<ni && ni <= n && 0 < nj && nj <=n){
						if(map[ni][nj] == 0 && group[nj][ni] == 0){
							group[ni][nj] = group[i][j];
							System.out.printf("%d,%d,%d\n",i,j,group[i][j]);
							q.offer(new Pair(ni,nj));
						}
					}
				}
				System.out.println("loop");
			}
		}




		public static void make_group(){
			int group_number = 0;
			for(int i = 1; i <= n; i++){
				for(int j = 1; j <= n; j++){
					if(map[i][j] == 1 && group[i][j] == 0){
						group[i][j] = ++group_number;
						q = new LinkedList<Pair>();
						q.offer(new Pair(i,j));
						while(!q.isEmpty()){
							Pair p = q.poll();
							int x = p.left();
							int y = p.right();

							Pair[] list = new Pair[4];
							list[0] = new Pair(x+1,y);
							list[1] = new Pair(x-1,y);
							list[2] = new Pair(x,y+1);
							list[3] = new Pair(x,y-1);

							for(Pair tmp : list){
								if(0<tmp.left()&& tmp.left() <=n && 0<tmp.right()&& tmp.right() <=n &&map[tmp.left()][tmp.right()] == 1&&group[tmp.left()][tmp.right()] == 0){
									q.add(tmp);
									group[tmp.left()][tmp.right()]=group_number;
								}
							}
						}
					}
				}
			}
		}

		public static void main(String[] args) throws IOException{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			n = Integer.parseInt(br.readLine());
			StringTokenizer st;

			map = new int[n+1][n+1];
			group = new int[n+1][n+1];

			for(int i = 1; i <= n; i++){
				st = new StringTokenizer(br.readLine());
				for(int j = 1; j <= n; j++){
					map[i][j] = Integer.parseInt(st.nextToken());
					group[i][j] = 0;
				}
			}
			make_group();
			make_bridge();

			for(int i = 1; i <= n; i++){
				for(int j = 1; j <= n; j++){
					System.out.print(group[i][j]);
				}
				System.out.println("");
			}



		}
	}