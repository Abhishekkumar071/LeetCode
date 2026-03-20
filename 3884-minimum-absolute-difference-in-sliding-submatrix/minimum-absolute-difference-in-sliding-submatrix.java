class Solution {
    private int find(int[][] arr, int r, int c, int k){
        int min = Integer.MAX_VALUE;
        Set<Integer> set = new TreeSet<>();
        for(int i=r; i<r+k; i++){
            for(int j=c; j<c+k; j++){
                set.add(arr[i][j]); 
            }
        }
        List<Integer> a = new ArrayList<>(set);

        for(int i=0; i<a.size()-1; i++) {
            if(Math.abs(a.get(i)-a.get(i+1))<min){
                min = Math.abs(a.get(i)-a.get(i+1));
            }
        }
        return min==Integer.MAX_VALUE? 0: min;
    }
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] ans = new int[m-k+1][n-k+1];
        for(int i=0; i<=m-k; i++){
            for(int j=0; j<=n-k; j++){
                int mi = find(grid, i, j, k);
                ans[i][j] = mi;
            }
        }
        return ans;
    }
}