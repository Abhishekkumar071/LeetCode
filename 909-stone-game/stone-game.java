class Solution {
Integer[][] memo;
    int maxDiff(int i, int j, int[] nums){
        if(i==j) return nums[i];
        if(memo[i][j]!=null) return memo[i][j];
        return  memo[i][j]=Math.max(
            nums[i]-maxDiff(i+1, j, nums),
            nums[j]-maxDiff(i, j-1, nums)
        );
    }
    public boolean stoneGame(int[] piles) {
        int n=piles.length;
        memo = new Integer[n][n];
        // for(int[] mm: memo)Arrays.fill(mm, -1);
        return maxDiff(0, n-1, piles)>0;
    }
}