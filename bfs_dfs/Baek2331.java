import java.util.*;

class Baek2331{
	public static int cal(int a, int p){
		int res = 0;
		while(a > 0){
			 res += (int)Math.pow(a%10,p);
			 a = a/10;
		}
		return res;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ans = 0;
		ArrayList<Integer> arr = new ArrayList<>();
		int a = sc.nextInt();	
		int p = sc.nextInt();
		arr.add(a);

		while(true){		
			a = cal(a,p);
			if(arr.contains(a)){
				break;
			}
			arr.add(a);
		}
		while(a !=  arr.get(ans)){
			ans++;
		}
		System.out.println(ans);
	}
}