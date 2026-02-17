class Solution {

    private int bs(int[] arr, int q){
        int l = 0, r = arr.length;
        while(l < r){
            int mid = l + (r - l) / 2;
            if(arr[mid] < q) l = mid + 1;
            else r = mid;
        }
        return l;
    }

    public List<Long> minOperations(int[] nums, int[] qu) {

        Arrays.sort(nums);
        int n = nums.length;

        long[] prefix = new long[n];
        prefix[0] = nums[0];
        for(int i = 1; i < n; i++)
            prefix[i] = prefix[i-1] + nums[i];

        List<Long> ans = new ArrayList<>();

        for(int q : qu){

            int idx = bs(nums, q);
            long left = 0, right = 0;
            if(idx > 0){
                left = (long) q * idx - prefix[idx-1];
            }
            if(idx < n){
                right = (prefix[n-1] - (idx>0?prefix[idx-1]: 0))- (long) q * (n - idx);
            }
            ans.add(left + right);
        }

        return ans;
    }
}
