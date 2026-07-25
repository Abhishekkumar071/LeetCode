class Solution {
    public int minSteps(int n) {
        int ans=0;
        for(int d=2; d*d<=n; d++){
            while(n%d==0){
                ans+=d;
                n/=d;
            }
        }
        if(n>1) ans+=n;
        return ans;
        // i think my approch is wrong..
        // if(prime number) return n;
        //nhii toh--: sare divisor jo uss number ko divide kr rha hain 
        // divisor+ (n/divisor);
        // i think all the sum of prime fector of a number
    }
}