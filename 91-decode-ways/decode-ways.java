class Solution {
    int n;
    int[] memo;
    private int allWay(String s, int i){
        if(i>=n) return 1;
        //Invalid
        if(s.charAt(i)=='0') return 0;
        if(memo[i]!=-1) return memo[i];
        int first = allWay(s, i+1);
        int second=0;
        if(i+1<n){
            int val = Integer.parseInt(s.substring(i, i+2));
            if(val>=10 && val<=26){
                second=allWay(s, i+2);
            }
        } 
        return memo[i]=first+second;
    }
    public int numDecodings(String s) {
        n=s.length();
        if(n==1 && s.charAt(0)=='0') return 0;
        memo = new int[n+1];
        Arrays.fill(memo, -1);
        return allWay(s, 0);
    }
}