class Solution {
    public int numberOfSubmatrices(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[][][] freq = new int[m][n][3]; // 0='.', 1='X', 2='Y'

        // Prefix sum build
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int dot = 0, x = 0, y = 0;

                if (i > 0) {
                    dot += freq[i - 1][j][0];
                    x   += freq[i - 1][j][1];
                    y   += freq[i - 1][j][2];
                }

                if (j > 0) {
                    dot += freq[i][j - 1][0];
                    x   += freq[i][j - 1][1];
                    y   += freq[i][j - 1][2];
                }

                if (i > 0 && j > 0) {
                    dot -= freq[i - 1][j - 1][0];
                    x   -= freq[i - 1][j - 1][1];
                    y   -= freq[i - 1][j - 1][2];
                }

                // current cell
                if (grid[i][j] == '.') dot++;
                else if (grid[i][j] == 'X') x++;
                else y++;

                freq[i][j][0] = dot;
                freq[i][j][1] = x;
                freq[i][j][2] = y;
            }
        }

        int ans = 0;

        // 🔥 your concept
        int idx = 0;
        if (grid[0][0] == 'X') idx = 1;
        if (grid[0][0] == 'Y') idx = 2;

        // count
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int countX = freq[i][j][1];
                int countY = freq[i][j][2];

                // ✅ both conditions
                if (freq[i][j][idx] > 0 && countX == countY && countX > 0) {
                    ans++;
                }
            }
        }

        return ans;
    }
}