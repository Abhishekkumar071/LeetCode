class Solution {
    public int maxProduct(int n) {
        int f=0;
        int s=0;
        while(n>0){
            int r = n%10;
            if(r>=f){
                s=f;
                f=r;
            }else if(f>r && r>s) s=r;
            n/=10;
        }
        return f*s;
    }
}