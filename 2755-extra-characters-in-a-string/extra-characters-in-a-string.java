class Solution {
    int[] memo;
    public int minExtraChar(String s, String[] dist) {
        memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return solve(s, dist, 0);
    }
    private int solve(String s, String[] dist, int i){
        if(i>=s.length()) return 0;
        if(memo[i]!=-1) return memo[i];
        int curr = 1 + solve(s, dist, i+1);
        for(String w: dist){
            if(w.length()+i<=s.length() && s.substring(i, i+w.length()).equals(w)){
                curr = Math.min(curr, solve(s, dist, i+w.length()));
            }
        }
        return memo[i]=curr;
    }
}