class Solution {
    int m, n;

    private boolean dfs(int r, int c, int pr, int pc, char[][] grid, boolean[][] vis) {
        vis[r][c] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int k = 0; k < 4; k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];

            // check bounds + same character
            if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == grid[r][c]) {

                if (!vis[nr][nc]) {
                    if (dfs(nr, nc, r, c, grid, vis)) {
                        return true;
                    }
                } 
  
                else if (nr != pr || nc != pc) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean containsCycle(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        boolean[][] vis = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j]) {
                    if (dfs(i, j, -1, -1, grid, vis)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}