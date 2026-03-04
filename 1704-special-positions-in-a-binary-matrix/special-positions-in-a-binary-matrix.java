class Solution {
    public int numSpecial(int[][] mat) {
        int ans=0;
        int m = mat.length;
        int n = mat[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                boolean found = false;
                if(mat[i][j]==1){
                    for(int k=0; k<m; k++){
                        if(mat[k][j]==1 && k!=i){
                            found = true;
                            break;
                        }
                    }
                    if(found) break;

                    for(int k=0; k<n; k++){
                        if(mat[i][k]==1 && k!=j){
                            found=true;
                            break;
                        }
                    }
                    if(found) break;
                    ans++;
                }
            }
        }
        return ans;
    }
}