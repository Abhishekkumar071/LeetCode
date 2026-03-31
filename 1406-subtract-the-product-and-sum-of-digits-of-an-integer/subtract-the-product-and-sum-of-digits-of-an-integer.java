class Solution {
    private void find(int n, int[] p){
        int prod = 1;
        int sum = 0;
        while(n>0){
            int r = n%10;
            sum+=r; prod*=r;
            n/=10;
        }
        p[0]=sum;
         p[1]=prod;
    }
    public int subtractProductAndSum(int n) {
        int[] prd = new int[2];
        find(n, prd);
        return prd[1]-prd[0];
    }
}