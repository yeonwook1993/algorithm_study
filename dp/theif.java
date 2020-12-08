class Solution {
    public int solution(int[] money) {
        int len = money.length;
        int[] dp1 = new int[len];
        int[] dp2 = new int[len];
        dp1[0] = money[0];
        dp1[1] = Math.max(money[1],money[0]);
        
        dp2[0] = 0;
        dp2[1] = money[1];
        
        for(int i = 2; i <len; i++){
            if(i == len-1){
                dp1[i] = Math.max(dp1[i-2] , dp1[i-1]);
                dp2[i] = Math.max(dp2[i-2] + money[i] , dp2[i-1]);
            } else {
                dp1[i] = Math.max(dp1[i-2] + money[i] , dp1[i-1]);
                dp2[i] = Math.max(dp2[i-2] + money[i] , dp2[i-1]);    
            }
            
        }
               
        return Math.max(dp1[money.length-1],dp2[money.length-1]);
    }
}