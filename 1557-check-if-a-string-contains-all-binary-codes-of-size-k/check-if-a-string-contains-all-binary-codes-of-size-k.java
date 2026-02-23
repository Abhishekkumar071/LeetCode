class Solution {
    HashSet<String> ans = new HashSet<>();
    private  void addAll(int k, String curr){
        if(curr.length()==k){
            ans.add(curr);
            return;
        }
        addAll(k, curr+"1");
        addAll(k, curr+"0");
    }
    public boolean hasAllCodes(String s, int k) {
        if(s.length()<k) return false;
        // addAll(k, "");

        for(int i=0; i<=s.length()-k; i++){
            ans.add(s.substring(i, i+k));
        }
        // System.out.println(ans);
        if(ans.size()>= (int)Math.pow(2, k)) return true;
        return false;
    }
}