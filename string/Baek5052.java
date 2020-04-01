import java.io.*;
import java.util.*;


public class Baek5052{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		boolean[] result = new boolean[n];

		for(int i = 0; i < n; i++){
			int size = Integer.parseInt(br.readLine());
			String[] buf = new String[size];
			boolean flag = false;

			for(int j = 0; j < size; j++){
				StringTokenizer st = new StringTokenizer(br.readLine());
				buf[j] = st.nextToken();
			}
			Arrays.sort(buf,new Comparator<String>(){
				@Override
				public int compare(String s1,String s2){
					return Integer.compare(s1.length(),s2.length());
				}
			});
			
			int cursor = 0;
			for(int k = 1; k < buf.length;k++){
				if(flag)	break;
				if(buf[k].length() > buf[k-1].length()){
					cursor = k-1;
				}
				for(int l = 0; l <= cursor; l++){
					if(buf[k].startsWith(buf[l])){
						flag = true;
						break;
					}
				}
			}
			result[i] = flag;
		}
		for (boolean e : result){
			if(e)	System.out.println("NO");
			else System.out.println("YES");
		}
	}
}


// time out 을 해결하기 위해 
// 1. 길이순으로 정렬한다.
// 2. 기존의 방식은 이전 번호들을 일일이 다 대조했으나 O(n^2)으로 상당히 오래 걸림
// 3. 같은 길이의 전화번호끼리는 같을 수 없으므로 자신보다 짧은 길이의 번호들만 포함여부 대조
