class Solution {
    public int longestSubarray(int[] nums) {
        int len=0;
        int max=0;
        for(int ele: nums)if(ele>max) max=ele;
        int curr=0;
        for(int ele: nums){
            if(ele==max){
                curr++;
                len = Math.max(len, curr);
            }
            else curr=0;
        }
        return len;
    }
}