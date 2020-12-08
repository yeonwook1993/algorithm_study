import java.util.Arrays;
import java.util.Collections;


class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int x = 0, y = people.length-1;
        
        while(x <= y){
            if(people[x] +people[y] > limit){
                answer++;
                y--;
            } else {
                answer++;
                x++;
                y--;
            }
        }
                
        return answer;
    }
}