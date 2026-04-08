class Solution {
    Boolean[] memo;
    public boolean canJump(int[] nums) {
        memo = new Boolean[nums.length];
        return solve(nums, 0);
    }
    public boolean solve(int[] nums, int idx){
        if(idx>=nums.length-1) return true;
        if(memo[idx]!=null) return memo[idx];
        int maxJump = nums[idx];
        for(int step=1; step<=maxJump; step++){
            if(solve(nums, idx+step)) return memo[idx] = true;
        }
        return memo[idx]=false;
    }
}