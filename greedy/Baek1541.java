import java.io.*;
import java.util.*;


public class Baek1541{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] buf = new int[50];
		int cursor = 0;
		while(st.hasMoreTokens()){
			String line = st.nextToken("-");
			if(line.indexOf("+")!= -1){
				String[] tmp = line.split("\\+");
				int num = 0;
				for(int i=0; i < tmp.length; i++){
					num += Integer.parseInt(tmp[i]);
				}
				buf[cursor] = num;
			} else {
				buf[cursor] = Integer.parseInt(line);
			}
			cursor ++;
		}
		int result = buf[0];
		for(int i = 1; i < buf.length;i++){
			result -= buf[i];
		}
		System.out.println(result);
	}
}