class Solution {
    long[][][] memo;

    long find(int m, int n, int mM, int r, int c){
        if(r<0 || r>=m || c<0 || c>=n) return 1;
        if(mM<=0) return 0;
        if(memo[mM][r][c]!=-1) return memo[mM][r][c];
        long f = find(m, n, mM-1, r-1, c);
        long s = find(m, n, mM-1, r, c+1);
        long t = find(m, n, mM-1, r+1, c);
        long fo = find(m, n, mM-1, r, c-1);

        return memo[mM][r][c] = (long)(f+s+t+fo)%1000000007;
    }
    public int findPaths(int m, int n, int mM, int r, int c) {
        memo = new long[mM+1][m+1][n+1];
        for(long[][] rr: memo){
            for(long[] r1: rr) Arrays.fill(r1, -1);
        }
        return (int)find(m, n, mM, r, c);
    }
}