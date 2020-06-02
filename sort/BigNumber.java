import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        Integer[] buf = Arrays.stream( numbers ).boxed().toArray( Integer[]::new );
        Arrays.sort(buf, new Comparator<Integer>(){
            @Override
			public int compare(Integer s1,Integer s2){
                String o1 = Integer.toString(s1);
                String o2 = Integer.toString(s2);
                
                return (o2+o1).compareTo(o1+o2);
            }       
        });
        String answer = "";
        
        for (Integer e : buf){
            answer = answer.concat(Integer.toString(e));
        }
        // 0000000 과 같은 답이 나올 경우 예외 처리
        if("0".equals(answer.substring(0, 1)))
            return "0";
        return answer;
    }
}


//프로그래머스 가장 큰수 