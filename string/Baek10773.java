import java.util.*;
import java.io.*;
public class Baek10773{
	public static void main(String[] args){
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			ArrayList<Integer> ans = new ArrayList<Integer>();
			int n = Integer.parseInt(br.readLine());
			for(int i = 0; i < n; i++){
				int input = Integer.parseInt(br.readLine());
				if(input == 0){
					ans.remove(ans.size()-1);
				} else {
					ans.add(input);
				}
			}
			int tmp = 0;
			for(int j = 0; j < ans.size(); j++){
				tmp = tmp + ans.get(j);
			}
			System.out.println(tmp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}