class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int ans=0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i==0 && j==0) continue;
                else if(i==0) grid[i][j]+=grid[i][j-1];
                else if(j==0) grid[i][j]+=grid[i-1][j];
                else grid[i][j] += grid[i-1][j] + grid[i][j-1] - grid[i-1][j-1];
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                // System.out.print(grid[i][j]+" ");
                if(grid[i][j]<=k)ans++;
            }
            // System.out.println();
        }
        return ans;
    }
}