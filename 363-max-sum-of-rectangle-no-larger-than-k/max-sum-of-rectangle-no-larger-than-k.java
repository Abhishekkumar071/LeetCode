class Solution {
    int getSum(int[][] prefix, int r1, int c1, int r2, int c2){
        r1++;r2++;c1++;c2++;
        return prefix[r2][c2]-
                          prefix[r1-1][c2]
                          -prefix[r2][c1-1]
                          +prefix[r1-1][c1-1];
    }
    public int maxSumSubmatrix(int[][] mat, int k) {
        int ans = Integer.MIN_VALUE;
        int m = mat.length;
        int n = mat[0].length;
        int[][] pref = new int[m+1][n+1];
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                pref[i][j]=mat[i-1][j-1]+
                           pref[i-1][j]+
                           pref[i][j-1]-
                           pref[i-1][j-1];
            }
        }
        // for(int[] a: pref){
        //     System.out.println(Arrays.toString(a));
        // }
        for(int r1=0; r1<m; r1++){
            for(int c1=0; c1<n; c1++){
                for(int r2=r1; r2<m; r2++){
                    for(int c2=c1; c2<n; c2++){
                        int sum = getSum(pref, r1, c1, r2, c2);
                        if(sum<=k) ans =Math.max(ans, sum);
                    }
                }
            }
        }
        return ans;
    }
}