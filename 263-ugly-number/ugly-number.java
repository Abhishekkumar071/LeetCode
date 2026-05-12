class Solution {
    public boolean isUgly(int n) {
        // if(n==-2147483648) return true;
        while(n>=1){
            if(n%5==0) n/=5;
            else if(n%3==0)n/=3;
            else if(n%2==0)n/=2;
            else return (n==1)?true:false;
        }
        return false;
    }
}