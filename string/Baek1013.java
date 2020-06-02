//
import java.util.*;
import java.io.*;

public class Baek1013{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i ++){
			String input = br.readLine();
			if(isCorrect(input)){
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
	public static boolean isCorrect(String input) throws Exception{
		String regExp = "^(100+1+|01)*$";
		if(input.matches(regExp)){
			return true;
		} else {
			return false;
		}
	}
}

//정규포현식
// ^ -> 문자의 시직을 의미
// $ -> 문자의 종료를 의미

