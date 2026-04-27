class Solution {
    public boolean hasValidPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        // directions: up, down, left, right
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

        // allowed moves for each type
        int[][][] moves = {
            {},
            {{0,-1},{0,1}},        // 1
            {{-1,0},{1,0}},        // 2
            {{0,-1},{1,0}},        // 3
            {{0,1},{1,0}},         // 4
            {{0,-1},{-1,0}},       // 5
            {{0,1},{-1,0}}         // 6
        };

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        visited[0][0] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            if(x == m-1 && y == n-1) return true;

            for(int[] d : moves[grid[x][y]]) {
                int nx = x + d[0];
                int ny = y + d[1];

                if(nx < 0 || ny < 0 || nx >= m || ny >= n || visited[nx][ny])
                    continue;

                // check reverse connection
                for(int[] back : moves[grid[nx][ny]]) {
                    if(nx + back[0] == x && ny + back[1] == y) {
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                        break;
                    }
                }
            }
        }

        return false;
    }
}