class Solution {
    public int mirrorFrequency(String s) {
        int[] freq = new int[123];

        for(char ch: s.toCharArray()){
            freq[ch]++;
        }
        int ans = 0;
        boolean[] vis = new boolean[123];

        for(char ch: s.toCharArray()){
            if(vis[ch]) continue;
            char m = mirror(ch);
            ans += Math.abs(freq[ch]-freq[m]);
            vis[ch]=true; vis[m]=true;
        }
        return ans;
    }
    private char mirror(char ch){
        if(ch>='a' && ch<='z') return (char)('a'+('z'-ch));
        return (char)('0'+('9'-ch));
    }
}