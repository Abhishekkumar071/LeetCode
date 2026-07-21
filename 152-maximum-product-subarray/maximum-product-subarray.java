class Solution {
    public int maxProduct(int[] nums) {
        int maxMul = nums[0];
        int n = nums.length;
        int curr=nums[0];
        int prev=nums[0];
        for(int i=1; i<n; i++){
            if(nums[i]<0){
                int temp=prev;
                prev = curr;
                curr=temp;
            }
            curr = Math.max(curr*nums[i], nums[i]);
            prev = Math.min(prev*nums[i], nums[i]);
            maxMul = Math.max(maxMul, curr);
        }
        return maxMul;
    }
}