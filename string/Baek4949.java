import java.util.*;
import java.io.*;
public class Baek4949{
	public static void main(String[] args){
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			ArrayList<String> list = new ArrayList<String>();
			String a = br.readLine();
			while(!a.equals(".")){
				if(isCorrect(a)){
					list.add("yes");
				} else {
					list.add("no");
				}
				a = br.readLine();	
			}
			for(int i = 0; i < list.size();i++){
				System.out.println(list.get(i));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static boolean isCorrect(String input){
		Stack<Character> stack = new Stack<Character>();
		
		for(int i = 0; i < input.length(); i++){
			if(input.charAt(i) == '[' || 
				input.charAt(i) == '('){
				stack.push(input.charAt(i));
			}
			if(input.charAt(i) == ']'){
				if(stack.empty()){
					return false;
				}
				char tmp = stack.pop();
				if(tmp != '['){
					return false;
				}
			}
			if(input.charAt(i) == ')'){
				if(stack.empty()){
					return false;
				}
				char tmp = stack.pop();
				if(tmp != '('){
					return false;
				}
		}
	}
	if(stack.empty()){
		return true;	
	} else {
		return false;
	}
	
}
}