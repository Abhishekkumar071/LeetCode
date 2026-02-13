class Solution {
    public long[]  getDistances(int[] nums) {
        int n = nums.length;
        long[] ans = new long[n];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }

        for (List<Integer> a: map.values()) {
            int s = a.size();
            long[] pre = new long[s];
            pre[0] = a.get(0);
            for(int i=1; i<s; i++) pre[i] = pre[i-1]+a.get(i);
            
            for(int k=0; k<s; k++){
                long curr = a.get(k);

                long left = (k>0)? pre[k-1]: 0;
                long right = pre[s-1]-pre[k];
                ans[(int)curr] = ((k*curr)-left) + (right-((s-k-1)*curr));
            }
        }
        return ans;
    }
}
