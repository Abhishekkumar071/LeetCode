class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int max = 0; 
        for (int i = 0; i < n1; i++) {
            if (i >= n2 || nums1[i] > nums2[i]) continue;

            int target = nums1[i];
            int l = i, r = n2 - 1;
            int bestJ = i;

            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (nums2[mid] >= target) {
                    bestJ = mid; // This is a candidate, try to find a larger one
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            max = Math.max(max, bestJ - i);
        }
        return max;
    }
}
