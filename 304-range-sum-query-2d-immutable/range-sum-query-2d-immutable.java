class NumMatrix {
    int[][] mat;
    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        mat = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                mat[i][j] = matrix[i][j];
            }
        }
    }
    
    public int sumRegion(int i, int j, int m, int n) {
        int sum = 0;

        for(int r=i; r<=m; r++){
            for(int c=j; c<=n; c++) sum += mat[r][c];
        }
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */