class Solution {
    public class Pair{
        char ch; int c;
        Pair(char ch, int c){
            this.ch = ch;
            this.c=c;
        }
    }
    public String removeDuplicates(String s, int k) {

        Stack<Pair> st = new Stack<>();
        for(char ch: s.toCharArray()){
            if(st.isEmpty()) st.push(new Pair(ch, 1));
            else if(st.peek().ch==ch && st.peek().c==k-1){
                for(int i=0; i<k-1; i++) st.pop();
            }

            else st.push(new Pair(ch, (st.peek().ch==ch)?st.peek().c+1: 1));
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop().ch);
        }
        return sb.reverse().toString();
    }
}