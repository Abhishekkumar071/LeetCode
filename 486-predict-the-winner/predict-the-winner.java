class Solution {
    int maxDiff(int i, int j, int[] nums){
        if(i==j) return nums[i];
        return Math.max(
            nums[i]-maxDiff(i+1, j, nums),
            nums[j]-maxDiff(i, j-1, nums)
        );
    }
    public boolean predictTheWinner(int[] nums) {
        // return maxDiff(0, nums.length-1, nums)>=0;
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
        
                int j = i + len - 1;
        
                if (i == j)
                    dp[i][j] = nums[i];
                else
                    dp[i][j] = Math.max(
                        nums[i] - dp[i + 1][j],
                        nums[j] - dp[i][j - 1]
                    );
            }
        }
        // for(int[] d: dp){
        //     System.out.println(Arrays.toString(d));
        // }
        return dp[0][n-1]>=0;
    }
}