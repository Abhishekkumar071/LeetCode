class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int currMax = nums[0];
        int max = nums[0];

        for(int i=1; i<n; i++){
            
            if(currMax<0){
                currMax = 0;
            }
            currMax += nums[i];
            max = Math.max(currMax, max);
        }
        max = Math.max(currMax, max);
        return max;
    }
}