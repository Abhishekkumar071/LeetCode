class Solution {
    public long countCommas(long n) {
        if(n==1000) return 1;
        long ans = 0;
        long p = 1000L;
        while(p<=n){
            ans += n-p+1;
            p *= 1000;
        }
        return ans;
    }
}