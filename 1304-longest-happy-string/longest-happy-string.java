class Solution {
    public class Pair{
        int val;
        char ch;
        Pair(int val, char ch){
            this.val=val;
            this.ch=ch;
        }
    }
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)->y.val-x.val);
        if(a>0)pq.add(new Pair(a, 'a'));
        if(b>0)pq.add(new Pair(b, 'b'));
        if(c>0)pq.add(new Pair(c, 'c'));

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Pair f = pq.poll();

            int len = sb.length();
            if(len>=2 && sb.charAt(len-1)==f.ch && sb.charAt(len-2)==f.ch){
                if(pq.isEmpty()) break;
                Pair s = pq.poll();
                sb.append(s.ch);
                s.val--;

                if(s.val>0)pq.add(s);
                pq.add(f);
            }
            else{
                sb.append(f.ch);
                f.val--;
                if(f.val>0)pq.add(f);
            }
        }
        return sb.toString();
    }
}