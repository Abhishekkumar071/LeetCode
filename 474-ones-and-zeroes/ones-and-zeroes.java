class Solution {
    private int find(String[] strs, int idx, int m, int n, int[][][] dp){
        if(idx>=strs.length) return 0;
        if(dp[idx][m][n]!=-1) return dp[idx][m][n];
        String s = strs[idx];
        int z=0, one=0;
        for(char ch: s.toCharArray()){
            if(ch=='1')one++; else z++;
        }
        int take = 0;
        if(m>=z && n>=one){
            take = 1+find(strs, idx+1, m-z, n-one, dp); 
        }
        int not = find(strs, idx+1, m, n, dp);
        return dp[idx][m][n]=Math.max(take, not);
    }
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length][m+1][n+1];

        for(int i=0; i<strs.length; i++){
            for(int j=0; j<=m; j++){
                for(int k=0; k<=n; k++) dp[i][j][k]=-1;
            }
        }
        return find(strs, 0, m, n, dp);
    }
}