class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        int i=0, j=0;
        while(i<n1 && j<n2){
            if(nums1[i]>nums2[j])i++;
            j++;
        }
        return Math.max(0, j-i-1);
    }
}