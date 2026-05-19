class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int n = nums1.length;
        HashSet<Integer> set = new HashSet<>();
        for(int ele: nums1) set.add(ele);
        for(int ele: nums2){
            if(set.contains(ele)) return ele;
        }
        return -1;
    }
}