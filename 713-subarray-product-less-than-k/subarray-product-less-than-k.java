class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans = 0;
        int n = nums.length;
        for(int i=0; i<n; i++){
            int mul=1;
            for(int j=i;j<n; j++){
                if(mul*nums[j]<k){
                    mul*=nums[j];
                    ans++;
                } 
                else break;
            }
        }
        return ans;
    }
}