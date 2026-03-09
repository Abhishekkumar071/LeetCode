class Solution {
    Integer[][] memo;
    private int solve(int r, int c, int[][] mat){
        if(r<0 || c<0 || r>=mat.length||c>=mat.length) return 1000000;
        if(mat.length-1==r) return mat[r][c];
        if(memo[r][c] != null) return memo[r][c];

        int  curr = mat[r][c];
        int f = solve(r+1, c-1, mat);
        int s = solve(r+1, c, mat);
        int t = solve(r+1, c+1, mat);

        return memo[r][c]=Math.min(f, Math.min(s, t))+curr;
    }
    public int minFallingPathSum(int[][] mat) {
        int min = 1000000;
        int n = mat.length;
       
        for(int i=0; i<n; i++){
            memo = new Integer[n+1][n+1];
            min = Math.min(min, solve(0, i, mat));
        }
        return min;
    }
}