class Solution {
    void check(String s, int st, List<String> ans, String curr, int count){
        if(count==4){
            if(s.length()==st){
                ans.add(curr.substring(0, curr.length()-1));
                // System.out.println(curr);
            }
            return;
        }
        String t = "";
        for(int i=st; i<s.length() && i<st+3; i++){
            t+= s.charAt(i);
            if(t.length()>1 && t.charAt(0)=='0') break;

            int v = Integer.parseInt(t);
            if(v>255) break;
            check(s, i+1, ans, curr+t+".", count+1);
        }
    }
    public List<String> restoreIpAddresses(String s) {
        int n = s.length();
        List<String> ans = new ArrayList<>();
        if(n>12) return ans; 
        check(s, 0, ans, "", 0);
        return ans;  
    }
}