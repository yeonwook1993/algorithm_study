import java.util.*;

public class Baek1516 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer>[] list = new ArrayList[n+1];
        
        for(int i = 1; i <= n; i ++){
            list[i] = new ArrayList<Integer>();
        }
        int[] total_time = new int[n+1];
        int[] order = new int[n+1];
        int[] time = new int[n+1]; 

        for(int it = 1; it <= n; it++){
            time[it] = sc.nextInt();
            total_time[it] = time[it];
            while(true){
                int prev = sc.nextInt();
                if(prev == -1){
                    break;
                } else {
                    order[it] += 1;
                    list[prev].add(it);
                }
            }
        }

        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 1; i <= n; i++){
            if(order[i] == 0){
                q.offer(i);
            }
        }
        
        for(int i = 1; i<= n; i++){
            int prev = q.poll();
            
            for(int e : list[prev]){
                order[e] -= 1;
                if(total_time[e] < total_time[prev] + time[e])
                    total_time[e] = total_time[prev] + time[e];
                if(order[e] == 0){
                    q.offer(e);
                }
            }
        }
        for(int i = 1; i<=n; i++){
            System.out.println(total_time[i]);
        }
        
    }
}