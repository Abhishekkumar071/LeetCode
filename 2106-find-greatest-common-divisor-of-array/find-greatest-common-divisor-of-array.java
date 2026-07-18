class Solution {
    public int findGCD(int[] nums) {
        int min = 1001;
        int max = 0;
        for(int ele: nums){
            if(min>ele) min = ele;
            if(max<ele) max = ele;
        }
        return gcd(min, max);
    }
    int gcd(int a, int b){
        if(a==0) return b;
        return gcd(b%a, a);
    }
}