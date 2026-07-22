class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long ans = Long.MIN_VALUE;
        long[] pSum = new long[n + 1];

        long sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            pSum[i + 1] = pSum[i] + nums[i];

            int a1 = nums[i] + k;
            int a2 = nums[i] - k;

            if (map.containsKey(a1)) {
                ans = Math.max(ans, pSum[i + 1] - pSum[map.get(a1)]);
            }

            if (map.containsKey(a2)) {
                ans = Math.max(ans, pSum[i + 1] - pSum[map.get(a2)]);
            }

            if (!map.containsKey(nums[i]) || pSum[map.get(nums[i])] > pSum[i]) {
                map.put(nums[i], i);
            }
        }
        return ans == Long.MIN_VALUE ? 0 : ans;
    }
}