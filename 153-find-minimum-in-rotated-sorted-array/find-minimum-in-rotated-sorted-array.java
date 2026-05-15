class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int last = nums[n-1];
        int left = 00, right=n-1;
        while(left<right){
            int mid = (left+right)>>1;
            if(nums[mid]>last) left=mid+1;
            else right =mid;
        }
        return nums[left];
    }
}