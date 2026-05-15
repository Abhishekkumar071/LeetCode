class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int last = nums[n-1];
        int left = 0, right=n-1;
        while(left<right){
            int mid = (left+right)>>1;
            if(nums[mid]>nums[right]) left=mid+1;
            else if(nums[mid]<nums[right])right =mid;
            else right--;
        }
        return nums[left];
    }
}