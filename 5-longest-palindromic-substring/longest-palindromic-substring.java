class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n<=1) return s;
        String ans = Character.toString(s.charAt(0));
        int max = 1;
        for(int i=0; i<n; i++){
            int l=i-1;
            int r=i+1;
            while(l>=0 && r<n){
                if(s.charAt(l)==s.charAt(r)){
                    if(max<(r-l+1)){
                        max=r-l+1;
                        ans=s.substring(l, r+1);
                    }
                    l--;
                    r++;
                }
                else break;
            }
            l=i;
            r=i+1;
            while(l>=0 && r<n){
                if(s.charAt(l)==s.charAt(r)){
                    if(max<(r-l+1)){
                        max=r-l+1;
                        ans=s.substring(l, r+1);
                    }
                    l--;
                    r++;
                }
                else break;
            }
        }
        return ans;
    }
}