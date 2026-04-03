import java.util.*;

class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];
        int n = s.length();

        for(char ch: s.toCharArray()) freq[ch-'a']++;

        for(int f: freq){
            if(f > (n+1)/2) return "";
        }

       
        StringBuilder sb = new StringBuilder();
        int last = -1;
        for(int i=0; i<n; i++){
            int pick = -1;
            for(int j=0; j<26; j++){
                if(freq[j] > 0 && j!=last){
                   if(pick==-1 || freq[j]>freq[pick]) pick=j;
                }
            }
            sb.append((char)('a'+pick)); 
            freq[pick]--;
            last=pick;
        }

        return sb.toString();
    }
}