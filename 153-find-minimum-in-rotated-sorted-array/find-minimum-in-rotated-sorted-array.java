class Solution {
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int ele: nums){
            if(min>ele) min=ele;
        }
        return min;
    }
}