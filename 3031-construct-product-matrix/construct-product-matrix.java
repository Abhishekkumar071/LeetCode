class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int size = m * n;
        int mod = 12345;
        int[] arr = new int[size];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                arr[i * n + j] = grid[i][j]%mod;

        int[] pre = new int[size];
        int[] suf = new int[size];

        pre[0] = 1;
        for (int i = 1; i < size; i++)
            pre[i] = (pre[i - 1] * arr[i - 1]) % mod;

        suf[size - 1] = 1;
        for (int i = size - 2; i >= 0; i--)
            suf[i] = (suf[i + 1] * arr[i + 1]) % mod;

        int[][] result = new int[m][n];
        for (int i = 0; i < size; i++)
            result[i / n][i % n] = (pre[i] * suf[i]) % mod;

        return result;
    }
}
