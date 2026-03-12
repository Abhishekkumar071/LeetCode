class Solution {
    int[][] memo;
    private int solve(int n, int e){
        if(e==1) return n;
        if(n<=1) return 1;
        if(memo[n][e]!=-1)return memo[n][e];
        int min = Integer.MAX_VALUE;
        for(int f=1; f<=n; f++){
            int yes = 1 + solve(f-1, e-1);
            int no = 1 + solve(n-f, e);
            min = Math.min(min, Math.max(yes, no));
        }
        return  memo[n][e]= min;
    }
    public int twoEggDrop(int n) {
        memo = new int[n+1][3];
        for(int[] r: memo) Arrays.fill(r, -1);
        return solve(n, 2);
    }
}