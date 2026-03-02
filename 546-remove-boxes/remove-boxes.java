class Solution {
    int[][][] memo;
    private int solve(int[] arr, int l, int r, int k){
        if(l>r) return 0;
        if(memo[l][r][k]!=0) return memo[l][r][k];

        int oL = l;
        int oK = k;

        while((l<r)&&arr[l]==arr[l+1]){
            l++; k++;
        }
        int ans = (k+1)*(k+1) + solve(arr, l+1, r, 0);
        for(int m=l+1; m<=r; m++){
            if(arr[m]==arr[l]){
                ans = Math.max(ans,
                    solve(arr, l+1, m-1, 0) + solve(arr, m, r, k+1));
            }
        }
        return memo[oL][r][oK]=ans;
    }
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        memo = new int[n][n][n];
        return solve(boxes, 0, n-1, 0);
    }
}