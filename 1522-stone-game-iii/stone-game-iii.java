class Solution {
    public String stoneGameIII(int[] ston) {
        int n = ston.length;
        int[] dp = new int[n+1];
        dp[n] = 0; 
        for(int i=n-1; i>=0; i--){
            int a = ston[i]-dp[i+1];
            int b=Integer.MIN_VALUE;
            int c=Integer.MIN_VALUE;
            if(i+2<=n){
                b = ston[i]+ston[i+1]-dp[i+2];
            }
            if(i+3<=n) c=ston[i]+ston[i+1]+ston[i+2]-dp[i+3];
            dp[i]=Math.max(a, Math.max(b, c));
        }
        int diff = dp[0];
        if(diff>0)return "Alice";
        else if(diff<0) return "Bob";
        else return "Tie";
    }
}