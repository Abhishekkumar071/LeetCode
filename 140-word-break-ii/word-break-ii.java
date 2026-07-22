class Solution {
    List<String> solve(String s, List<String> w1){
        if (s.equals("")) {
            List<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        List<String> ans = new ArrayList<>();
        for(int l=1; l<=s.length(); l++){
            String curr = s.substring(0, l);
            if(w1.contains(curr)){
                List<String> remain = solve(s.substring(l), w1);
                for(String w: remain){
                    if(w.equals("")) ans.add(curr);
                    else ans.add(curr+" "+w);
                }
            }
        }
        return ans;
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        return solve(s, wordDict);
    }
}