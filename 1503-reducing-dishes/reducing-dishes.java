class Solution {
    private int maxSat(int i, int t, int[] s, int[][] memo){
        if(i>=s.length) return 0;
        if(memo[i][t]!=-1) return memo[i][t];
        int take = s[i]*t + maxSat(i+1, t+1, s,memo);
        int not = maxSat(i+1, t, s, memo);
        return memo[i][t]=Math.max(take, not);
    }
    public int maxSatisfaction(int[] s) {
        Arrays.sort(s);
        int[][] memo = new int[s.length][s.length+1];
        for(int[] r:memo)Arrays.fill(r, -1);
        return maxSat(0, 1, s, memo);
    }
}