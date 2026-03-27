class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int m=mat.length;
        int n =  mat[0].length;
        k %= n;

        int[][] newMat = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=k; j<n; j++) newMat[i][j-k]=mat[i][j];
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<k; j++) newMat[i][n-k+j]=mat[i][j];
        }
        for(int i=0; i<m; i++){
            System.out.println(Arrays.toString(newMat[i]));
        }
        
        boolean yes = Arrays.deepEquals(newMat,mat);
        return yes;
    }
}