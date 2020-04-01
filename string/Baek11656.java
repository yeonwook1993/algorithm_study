import java.io.*;
import java.util.*;


public class Baek11656{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String word = st.nextToken();
		String[] buf = new String[word.length()];

		for (int i =0; i < word.length(); i++){
			buf[i] = word.substring(i,word.length());
		}
		Arrays.sort(buf);
		for(String e : buf){
			System.out.println(e);
		}
	}
}

