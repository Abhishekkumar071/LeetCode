class Solution {
    int n;
    Boolean[] memo;
    boolean solve(String s, int idx, List<String> w){
        if(idx==n)return true;
        if(memo[idx]!=null) return memo[idx];
        for(int len=1; len+idx<=n; len++){
            if(w.contains(s.substring(idx, len+idx)) && solve(s, len+idx,  w)) return memo[idx]=true;
        }return memo[idx]=false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        n = s.length();
        memo=new Boolean[n];
        return solve(s, 0, wordDict);
    }
}