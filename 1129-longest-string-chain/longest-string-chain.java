class Solution {
    boolean pred(String a, String b) {
        if (b.length() != a.length() + 1) return false;
        int i = 0, j = 0;
        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) == b.charAt(j)) {
                i++;
            }
            j++;
        }

        return i==a.length();
    }
    int[] memo;
    int solve(int idx, String[] words){
        if(idx>=words.length) return 1;
        if(memo[idx]!=-1) return memo[idx];
        int ans = 1;
        for(int i=idx+1; i<words.length; i++){
            if(pred(words[idx], words[i])) ans = Math.max(ans, 1+solve(i, words));
        }
        // int not = solve(idx+1, words);
        return memo[idx]=ans;
    }
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a,b)->a.length()-b.length());
        memo = new int[words.length];
        Arrays.fill(memo, -1);
        
        int ans = 1;

        for (int i = 0; i < words.length; i++) {
            ans = Math.max(ans, solve(i, words));
        }
    
        return ans;
    }
}