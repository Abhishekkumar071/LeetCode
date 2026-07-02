class Solution {
    static final int[][] dirs = {
        {1, 0}, {0, 1}, {-1, 0}, {0, -1}
    };

    int m, n;
    int[][] arr;
    int[][] best;

    boolean dfs(int i, int j, int health) {
        if (health < 1) return false;

        if (i == m - 1 && j == n - 1)
            return true;

        // Already reached this cell with equal or more health
        if (best[i][j] >= health)
            return false;

        best[i][j] = health;

        for (int[] d : dirs) {
            int x = i + d[0];
            int y = j + d[1];

            if (x >= 0 && x < m && y >= 0 && y < n) {
                int nextHealth = health - arr[x][y];
                if (dfs(x, y, nextHealth))
                    return true;
            }
        }

        return false;
    }

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        m = grid.size();
        n = grid.get(0).size();

        arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = grid.get(i).get(j);
            }
        }

        // Pay cost of the starting cell
        health -= arr[0][0];
        if (health < 1) return false;

        best = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(best[i], -1);
        }

        return dfs(0, 0, health);
    }
}