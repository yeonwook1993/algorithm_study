import java.util.*;

public class Beak2252 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Integer>[] list = new ArrayList[n+1];
        int[] order = new int[n+1];

        for(int i =0; i<= n; i++){
            list[i] = new ArrayList<Integer>();
        }
        for(int i =0; i <m; i++){
            int from = sc.nextInt();
            int to = sc.nextInt();
            list[from].add(to);
            order[to] += 1;
        }
        Queue<Integer> q = new LinkedList<Integer>();

        for(int i = 1; i <= n; i++){
            if(order[i] == 0){
                q.offer(i);
                System.out.print(i+" ");
            }
        }

        while(!q.isEmpty()){
            int prev = q.poll();
            for(int next : list[prev]){
                order[next] -= 1;
                if(order[next] == 0){
                    System.out.print(next+" ");
                    q.offer(next);
                }
            }
        }
    }
}