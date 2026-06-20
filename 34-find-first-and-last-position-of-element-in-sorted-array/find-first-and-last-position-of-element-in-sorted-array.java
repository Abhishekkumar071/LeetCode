class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n  = nums.length;
        int l=0;
        int r=n-1;
        int found = -1;
        while(l<r){
            int mid = l+(r-l)/2;
            if(nums[mid]==target){
                found=mid;
            }
            if(nums[mid]<target) l=mid+1;
            else r=mid;
        }
        while(r+1<n && nums[r]==nums[r+1])r++;
        if(found!=-1 || (l<n&&nums[l]==target&&nums[r]==target)) return new int[]{l,r};
        else return new int[]{-1, -1};
    }
}