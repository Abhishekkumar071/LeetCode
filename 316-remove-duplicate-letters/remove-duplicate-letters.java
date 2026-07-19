class Solution {
    public String removeDuplicateLetters(String s) {
        boolean[] vis = new boolean[26];
        int[] freq = new int[26];
        for(char ch: s.toCharArray()) freq[ch-'a']++;
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(char ch: s.toCharArray()){
            freq[ch-'a']--;
            if(vis[ch-'a']) continue;
            while(!st.isEmpty() && freq[st.peek()-'a']>0 && st.peek()>ch){
                vis[st.pop()-'a']=false;
            }
            st.push(ch);
            vis[ch-'a']=true;
        }
        while(!st.isEmpty()) sb.append(st.pop());
        return sb.reverse().toString();
    }
}