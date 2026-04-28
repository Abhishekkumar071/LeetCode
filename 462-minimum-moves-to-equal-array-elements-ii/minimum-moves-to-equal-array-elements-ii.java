class Solution {
    public int minMoves2(int[] nums) {
        int n = nums.length;
        int ans = 0;
        Arrays.sort(nums);
        int median = nums[n/2];
        for(int i=0; i<n; i++){
            ans += Math.abs(nums[i]-median);
        }
        return ans;
    }
}