class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> st = new Stack<>();
        int n = s.length();
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if(ch=='(') st.push(i);
            if(ch==')'){
                if(!st.isEmpty() && s.charAt(st.peek())=='(') st.pop();
                else st.push(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        HashSet<Integer> set = new HashSet<>();
        while(!st.isEmpty())set.add(st.pop());
        for(int i=0; i<n; i++){
            if(set.contains(i)) continue;
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}