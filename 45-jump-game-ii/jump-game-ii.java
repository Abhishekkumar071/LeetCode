class Solution {
    int[] memo;
    public int jump(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return solve(nums, 0);
    }
    private int solve(int[] nums, int idx){
        if(idx==nums.length-1) return 0;
        if(idx>nums.length-1) return 1000000007;

        if(memo[idx]!=-1) return memo[idx];
        int maxJump = nums[idx];
        int min=1000000007;
        for(int step=1; step<=maxJump; step++){
            min = Math.min(min, 1+solve(nums, idx+step));
        }
        return memo[idx]= min;
    }
}