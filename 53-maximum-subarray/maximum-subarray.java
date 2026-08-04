class Solution {
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int curr=0;
        for(int ele: nums){
            if(curr<0)curr=0;
            curr += ele;
            ans = Math.max(ans, curr);
        }
        return ans;
    }
}