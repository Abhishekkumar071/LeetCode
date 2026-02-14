class Solution {
    private int solve(int idx, int n, int taked, int[] nums, int[][] memo){
        if(idx>=n) return 0;
        if(memo[idx][taked]!=-1) return memo[idx][taked];

        int not = solve(idx+1, n, 0, nums, memo);
        int take = 0;
        if(taked==0){
            take = nums[idx] + solve(idx+1, n, 1, nums, memo);
        }
        return memo[idx][taked]=Math.max(take, not);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int[][] memo = new int[n][2];
        for(int[] r: memo) Arrays.fill(r, -1);
        int a = solve(0, n-1, 0, nums, memo);
        for(int[] r: memo) Arrays.fill(r, -1);
        int b = solve(1, n, 0, nums, memo);
        return Math.max(a, b);
    }
}