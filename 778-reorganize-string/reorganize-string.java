class Solution {
    public class Pair{
        int val;
        char ch;
        Pair(int val, char ch){
            this.val = val;
            this.ch = ch;
        }
    }
    public String reorganizeString(String s) {
        int[] freq = new int[26];
        for(char ch: s.toCharArray()){
            freq[ch-'a']++;
        }
        int n=s.length();
        for(int i=0; i<26; i++){
            if(freq[i]>(n+1)/2) return "";
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->b.val-a.val);
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<26; i++){
            if(freq[i]>0){
                pq.add(new Pair(freq[i], (char)('a'+i)));
            }
        }

        while(!pq.isEmpty()){
            Pair f = pq.poll();
            if(sb.length()>0 && sb.charAt(sb.length()-1)==f.ch){
                Pair s1 = pq.poll();
                sb.append(s1.ch);
                s1.val--;
                if(s1.val>0) pq.add(s1);
                pq.add(f);
            }
            else{
                sb.append(f.ch);
                f.val--;
                if(f.val>0) pq.add(f);
            }
        }
        return sb.toString();
    }
}