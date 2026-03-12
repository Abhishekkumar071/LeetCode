class Solution {
    int[][] memo;
    private int solve(int n, int e){
        if(e==1) return n;
        if(n<=1) return n;

        if(memo[n][e] != -1) return memo[n][e];

        int mini = Integer.MAX_VALUE;
        int lo=1;
        int hi=n;
        while(lo<=hi){
            int mid = lo+(hi-lo)/2;

            int yes = solve(mid-1, e-1);
            int no = solve(n-mid, e);

            mini = Math.min(mini, 1+Math.max(yes, no));
            if(yes>no){
                hi = mid-1;
            }else lo=mid+1;
        }
        return  memo[n][e]= mini;
    }
    public int superEggDrop(int k, int n) {
        memo = new int[n+1][k+1];
        for(int[] r: memo) Arrays.fill(r, -1);
        return solve(n, k);
    }
}