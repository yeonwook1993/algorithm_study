import java.util.Scanner;
import java.util.Arrays;

public class Baek1912 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
		}
		int max_val = 0;
		for (int i = 1; i < n; i++) {
			for (int j = 1; j <= n - i; j++) {
				int tmp = arr[j];
				for (int k = 1; k <= i; k++) {
					tmp += arr[j + k];
				}
				if (max_val <= tmp)
					max_val = tmp;
			}
		}
		System.out.println(max_val);
	}
}