class Solution {
    public long sumAndMultiply(int n) {
        String s = Integer.toString(n);
        long prod=0;
        long sum=0;
        for(char ch: s.toCharArray()){
            if(ch-'0'!=0){
                int v = ch-'0';
                prod = prod*10+v;
                sum+=v;
            }
        }return sum*prod;
    }
}