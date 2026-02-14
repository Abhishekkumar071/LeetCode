class Solution {
    private int solve(int idx, int prevTaked, int[] nums, int[][] memo){
        if(idx>=nums.length) return 0;
        if(memo[idx][prevTaked]!=-1) return memo[idx][prevTaked];

        int not = solve(idx+1, 0, nums, memo);
        int take=0;
        if(prevTaked!=1){
            take = nums[idx]+solve(idx+1, 1, nums, memo);
        }
        return memo[idx][prevTaked] = Math.max(not, take);
    }
    public int rob(int[] nums) {
        int[][] memo = new int[nums.length][2];
        for(int[] r: memo) Arrays.fill(r, -1);
        return solve(0, 0, nums, memo);
    }
}