class Solution {
    int[][] memo;
    private int yadav(int i, int j, int[] f, int[] s){
        if(i>=f.length || j>=s.length) return 0;
        if(memo[i][j]!=-1) return memo[i][j];
        if(f[i]==s[j]) return 1+yadav(i+1, j+1, f, s);

        return memo[i][j]=Math.max(yadav(i, j+1, f, s), yadav(i+1, j, f, s));
    }
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        memo = new int[m+1][n+1];
        for(int[] r: memo) Arrays.fill(r, -1);
        return yadav(0, 0, nums1, nums2);
    }
}