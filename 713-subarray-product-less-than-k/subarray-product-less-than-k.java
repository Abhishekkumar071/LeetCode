class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        // System.out.println(Arrays.toString(pref));
        for(int i=0; i<n; i++){
            int mul = 1;
            for(int j=i; j<n; j++){
                mul*=nums[j];
                if(mul<k) ans++;
                else break;
            }
        }
        return ans;
    }
}