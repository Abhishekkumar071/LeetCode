class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int ones = 0;
        for(char ch: s.toCharArray()) if(ch=='1')ones++;
        s= "1"+s+"1";
        int n  = s.length();
        int i = 0;
        int ans=ones;
        while(i<n && s.charAt(i)=='1') i++;
        int prev=0;
        while(i<n && s.charAt(i)=='0'){
            i++;
            prev++;
        }
        while(i<n){
            int o=0;
            while(i<n && s.charAt(i)=='1'){
                i++;
                o++;
            }
            if(o==0) break;
            int curr =0;
            while(i<n && s.charAt(i)=='0'){
                i++;
                curr++;
            }
            if(curr==0) break;
            ans = Math.max(ans, ones+curr+prev);
            prev=curr;
        }
        return ans;
    }
}