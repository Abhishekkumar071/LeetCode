class Solution {
    int n;
    int[] memo;
    int maxDiff(int i, int[] arr){
        if(i==n) return 0;
        if(memo[i]!=-1) return memo[i];
        int a=Integer.MIN_VALUE;
        int b=Integer.MIN_VALUE;
        int c=Integer.MIN_VALUE;
        a = arr[i]-maxDiff(i+1, arr);
        if(i+2<=n){
            b = arr[i]+arr[i+1]-maxDiff(i+2, arr);
        }
        if(i+3<=n){
            c = arr[i]+arr[i+1]+arr[i+2]-maxDiff(i+3, arr);
        }
        return memo[i]= Math.max(a, Math.max(b, c));
    }
    public String stoneGameIII(int[] ston) {
        n=ston.length;
        memo = new int[n];
        Arrays.fill(memo, -1);
        int diff = maxDiff(0, ston);
        if(diff>0)return "Alice";
        else if(diff<0) return "Bob";
        else return "Tie";
    }
}