class Solution {
    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int maxSum = 0;
        for(int ele: nums){
            if(maxSum<0){
                ans = Math.max(ans, maxSum);
                maxSum = 0;
            }
            maxSum+=ele;
            ans = Math.max(ans, maxSum);
        }
        return ans;
    }
}