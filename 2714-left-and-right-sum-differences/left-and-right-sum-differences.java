class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] l = new int[n];
        int[] r = new int[n];
        int[] ans = new int[n];
        l[0]=0;r[n-1]=0;
        for(int i=1; i<n; i++) l[i]=l[i-1]+nums[i-1];
        for(int j=n-2; j>=0; j--) r[j]=r[j+1]+nums[j+1];
        for(int k=0; k<n; k++) ans[k]=Math.abs(l[k]-r[k]);
        return ans;
    }
}