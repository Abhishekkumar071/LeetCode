class Solution {
    public long countOperationsToEmptyArray(int[] nums) {
        
        int n = nums.length;
        int[][] arr = new int[n][2];
        for(int i=0; i<n; i++){
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr, (a, b)->a[0]-b[0]);
        long ans = n;
        int prev = arr[0][1];
        for(int i=1; i<n; i++){
            int curr = arr[i][1];
            if(curr<prev) ans+=(n-i);
            prev=curr;
        }
        return ans;
    }
}