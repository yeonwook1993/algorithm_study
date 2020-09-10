import java.util.*;
class test{

	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(2);
		q.offer(3);
		q.offer(1);
		PriorityQueue<Integer> q2 = new PriorityQueue<Integer>();
		q2.offer(2);
		q2.offer(3);
		q2.offer(1);

		for(int i = 0; i <3; i++){
			int a = q.poll();
			int b = q2.poll();

			System.out.printf("q = %d,q2 = %d\n",a,b);
		}

	}
}