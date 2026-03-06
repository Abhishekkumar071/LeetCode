class Solution {
    public boolean checkOnesSegment(String s) {
        int n=s.length();
        boolean yes = false;
        for(int i=0; i<n; i++){
            if(s.charAt(i)=='1' && !yes){
                yes=true;
                while(i<n && s.charAt(i)=='1')i++;
            } 
            if(i<n&&yes && s.charAt(i)=='1') return false;
        }return yes;
    }
}