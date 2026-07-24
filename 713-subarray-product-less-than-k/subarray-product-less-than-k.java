class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        int l=0;
        if(k<=1) return 0;
        int mul = 1;
        for(int i=0; i<n; i++){
            mul*=nums[i];
            while(mul>=k){
                mul/=nums[l];
                l++;
            }
            if(mul<k) ans+=(i-l+1);
        }
        return ans;
    }
}