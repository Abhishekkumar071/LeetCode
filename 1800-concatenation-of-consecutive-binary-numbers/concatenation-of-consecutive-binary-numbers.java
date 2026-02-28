class Solution {
    public int concatenatedBinary(int n) {
        StringBuilder bb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            bb.append(Integer.toBinaryString(i));
        }

        long ans = 0;
        long pow = 1;
        int mod = 1000000007;
        for (int i = bb.length() - 1; i >= 0; i--) {
            if (bb.charAt(i) == '1') {
                ans = (ans + pow) % mod;
            }
            pow = (pow*2) % mod;
        }

        return (int) ans;
    }
}