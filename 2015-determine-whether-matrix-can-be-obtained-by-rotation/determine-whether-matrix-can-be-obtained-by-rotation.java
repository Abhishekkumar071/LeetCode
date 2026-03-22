class Solution {

    public int[][] rotate90(int[][] matrix) {
        int n = matrix.length;
        int[][] ans = new int[n][n];

        for(int i=n-1; i>=0; i--){
            for(int j=0; j<n; j++){
                ans[j][n-1-i] = matrix[i][j];
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                matrix[i][j] = ans[i][j];
            }
        }
        return matrix;
    }
    public boolean findRotation(int[][] mat, int[][] target) {
        for(int k=0; k<4; k++){
            if(Arrays.deepEquals(mat, target)) return true;
            mat = rotate90(mat);
        }
        return false;
    }
}