import java.util.Scanner;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.PriorityQueue;

class Pair{
	int total_time;
	int task;
	int phase;

	Pair(int total_time,int task,int phase){
		this.total_time = total_time;
		this.task = task;
		this.phase = phase;
	}

	int task(){
		return this.task;
	}
	int totalTime(){
		return this.total_time;
	}
	int phase(){
		return this.phase;
	}
}

class Baek2056{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] time = new int[n+1];
		int[] order = new int[n+1];
		int [] d = new int[n+1];

		ArrayList<Integer>[] list = new ArrayList[n+1];
		
		for (int i=1; i<=n; i++) {
            list[i] = new ArrayList<Integer>();
        }

		for(int task = 1; task<=n; task++){
			time[task] = sc.nextInt();
			int it = sc.nextInt();
			while(it > 0){
				int before_task = sc.nextInt();
				list[before_task].add(task);
				order[task] += 1;
				it--;
			}
		}
		Queue<Pair> q = new LinkedList<Pair>();
		
		for(int i = 1; i<=n; i++){
			if(order[i] == 0){
				q.offer(new Pair(time[i],i,1));
				d[i] = time[i];
			}
		}

		int ans2 = 0;
		for(int k = 1; k<=n; k++){

			Pair p = q.poll();
			int task = p.task();
			int total_time = p.totalTime();
			int phase = p.phase();
			ans2 = Math.max(total_time,ans2);
			System.out.println(ans2);
			for(int next_task : list[task]){
				order[next_task] -= 1;
				if(d[next_task] < d[task]+time[next_task]){
					d[next_task] = d[task]+time[next_task];
				}
				if(order[next_task] == 0){
					q.offer(new Pair(time[next_task]+total_time, next_task, phase+1));
				}
			}
		}
		int ans= 0;
		System.out.println("---------------");
		for(int i = 1; i <=n; i++){
			ans = Math.max(ans,d[i]);
			System.out.println(ans);
		}
		System.out.println(ans);
	}
}