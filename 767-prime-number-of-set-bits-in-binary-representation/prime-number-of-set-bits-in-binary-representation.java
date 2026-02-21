class Solution {
    private boolean[] prime = new boolean[1000001];

    public Solution() {
        for(int i = 0; i <= 1000000; i++) {
            prime[i] = true;
        }
        prime[0] = false;
        prime[1] = false;
        for(int i=2; i*i<=1000000; i++){
            if(prime[i]){
                for(int j=i*i; j<=1000000; j+=i) prime[j]=false;
            }
        }
    }

    public int countPrimeSetBits(int left, int right) {
        int ans = 0;

        for(int i = left; i <= right; i++) {
            int count = Integer.bitCount(i);
            if(prime[count]) {
                ans++;
            }
        }

        return ans;
    }
}