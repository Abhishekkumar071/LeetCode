class Solution {
    public int minOperations(int[][] grid, int x) {
        int ans=0;
        int r=grid[0][0]%x;
        int m = grid.length;
        int n = grid[0].length;
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]%x != r) return -1;
                list.add(grid[i][j]);
            }
        }
        Collections.sort(list);
        r = list.get(list.size()/2);
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                ans += Math.abs(r-grid[i][j])/x;
            }
        }
        return ans;
    }
}