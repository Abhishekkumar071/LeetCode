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
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a,b)->a.length()-b.length());
        int ans = 0;
        int n = words.length;
        int[] dp = new int[n];
        for(int i=n-1; i>=0; i--){
            dp[i]=1;
            for(int j=i+1; j<n; j++){
                if(pred(words[i], words[j])) dp[i]=Math.max(dp[i], dp[j]+1);
            }
            ans=Math.max(ans, dp[i]);
        }
        return ans;
    }
}