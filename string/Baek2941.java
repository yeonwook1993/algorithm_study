import java.io.*;
import java.util.*;


public class Baek2941{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String[] alphabet = {"c=","c-","dz=","d-","lj","nj","s=","z="};
		String sentence = st.nextToken();
		int count = 0;
		for(String a : alphabet) {
			sentence = sentence.replaceAll(a,"a");
		}
		System.out.println(sentence.length());
	}
}



// String 의     replaceAll Method 숙지할 것
// 추가적으로 replaceFirst, replace 두가지 모두 숙지할 수 있도록.
// 정규표현식 역시 공부
