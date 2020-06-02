import java.io.*;
import java.util.*;


public class Baek1543{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String doc = br.readLine();
		String sample = br.readLine();
		int doc_len, sample_len, cursor;
		doc_len = doc.length(); 
		sample_len = sample.length();
		cursor = 0;
		int answer = 0;

		while(cursor <= (doc_len - sample_len)){
			if(isCorrect(doc,sample,cursor,cursor+sample_len)){
				cursor = cursor + sample_len;
				answer++;
			} else {
				cursor++;
			}
		}
		System.out.println(answer);
	}

	public static boolean isCorrect(String doc, String sample, int start, int end){
		if(sample.equals(doc.substring(start,end))){
			return true;
		} else {
			return false;
		}
	}
}

