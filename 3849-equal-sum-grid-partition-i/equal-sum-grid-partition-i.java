class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        long[] col = new long[n];
        long[] row = new long[m];

        for(int c=0; c<n; c++){
            if(c!=0) col[c] += col[c-1];
            for(int i=0; i<m; i++){
                col[c] += grid[i][c];
            }
        }

        for(int r=0; r<m; r++){
            if(r!=0) row[r] += row[r-1];
            for(int j=0; j<n; j++){
                row[r] += grid[r][j];
            }
        }
        long tot = col[n-1];
        for(int i=0; i<n; i++){
            if(col[i]==(tot-col[i])) return true;
        }
        tot = row[m-1];
        for(int i=0; i<m; i++){
            if(row[i]==(tot-row[i])) return true;
        }
        return false;
    }
}