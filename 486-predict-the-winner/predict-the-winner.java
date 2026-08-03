class Solution {
    int maxDiff(int i, int j, int[] nums){
        if(i==j) return nums[i];
        return Math.max(
            nums[i]-maxDiff(i+1, j, nums),
            nums[j]-maxDiff(i, j-1, nums)
        );
    }
    public boolean predictTheWinner(int[] nums) {
        return maxDiff(0, nums.length-1, nums)>=0;
    }
}