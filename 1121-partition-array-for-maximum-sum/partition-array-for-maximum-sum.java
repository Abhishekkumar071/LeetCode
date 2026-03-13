class Solution {
    int[] memo;
    private int maxSum(int idx, int[] arr, int k){
        if(idx>=arr.length) return 0;
        if(memo[idx]!=-1) return memo[idx];
        int max = Integer.MIN_VALUE;
        int curr = 0;
        int eleMax = 0;
        for(int j=idx; j<arr.length && j<idx+k; j++){
            if(arr[j]>eleMax) eleMax = arr[j];
            curr = (j-idx+1)*eleMax + maxSum(j+1, arr, k);
            max = Math.max(max, curr);
        }
        return memo[idx]= max;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        memo= new int[arr.length+1];
        Arrays.fill(memo, -1);
        return maxSum(0, arr, k);
    }
}