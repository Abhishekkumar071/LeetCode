class Solution {
    int[]  memo;
    private int minNotes(int[] coins, int am){
        if(am==0) return 0;
        if(am<0) return Integer.MAX_VALUE;
        if(memo[am]!=-1) return memo[am];

        int min = Integer.MAX_VALUE;
        for(int coin: coins){
            int take = minNotes(coins, am-coin);
            if(take!=Integer.MAX_VALUE) min = Math.min(take+1, min);
        }
        return memo[am] = min;
    }
    public int coinChange(int[] coins, int amount) {
        memo=new int[amount+1];
        Arrays.fill(memo, -1);
        int a=minNotes(coins, amount);
        return Integer.MAX_VALUE==a?-1:a;
    }
}