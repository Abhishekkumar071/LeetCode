class Solution {
    private int allPossible(int idx, int[] coins, int am, int[][] memo){

        if(am==0) return 1;
        if(memo[idx][am]!=-1) return memo[idx][am];
        if(idx==coins.length) return 0;

        int not = allPossible(idx+1, coins, am, memo);
        int take = 0;
        if(am-coins[idx]>=0){
            take = allPossible(idx, coins, am-coins[idx], memo);
        }
        return memo[idx][am]= not+take;
    }
    public int change(int amount, int[] coins) {
        int[][] memo =  new int[coins.length+1][amount+1];
        for(int[] r: memo) Arrays.fill(r, -1);
        return allPossible(0,coins,amount, memo);
    }
}