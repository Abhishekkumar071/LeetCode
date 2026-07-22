class Solution {
    List<String> ans;
    void solve(int i, String s, String curr, List<String> w){
        if(i>=s.length()) {
            ans.add(curr);
            return;
        }
        for(int j=i; j<s.length(); j++){
            String word = s.substring(i, j+1);
            if(w.contains(word)){
                String temp = curr;
                if(curr.length()>0) curr+=" ";
                curr+=word;
                solve(j+1, s, curr, w);
                curr=temp;
            }
        }
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        ans = new ArrayList<>();
        solve(0, s,"", wordDict);
        return ans;
    }
}