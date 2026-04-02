class Solution {
    int m, n;
    Integer[][][] dp;

    private int solve(int i, int j, int[][] coins, int k) {
        if (i >= m || j >= n) return Integer.MIN_VALUE;

        if (i == m - 1 && j == n - 1) {
            if (coins[i][j] < 0 && k < 2) return 0; // neutralize robber
            return coins[i][j];
        }

        // Memoization
        if (dp[i][j][k] != null) return dp[i][j][k];

        int right = solve(i, j + 1, coins, k);
        int down = solve(i + 1, j, coins, k);

        int take = coins[i][j] + Math.max(right, down);

        int res = take;

        if (coins[i][j] < 0 && k < 2) {
            int rightSkip = solve(i, j + 1, coins, k + 1);
            int downSkip = solve(i + 1, j, coins, k + 1);

            int skip = Math.max(rightSkip, downSkip);
            res = Math.max(res, skip);
        }

        return dp[i][j][k] = res;
    }

    public int maximumAmount(int[][] coins) {
        m = coins.length;
        n = coins[0].length;
        dp = new Integer[m][n][3]; 
        return solve(0, 0, coins, 0);
    }
}