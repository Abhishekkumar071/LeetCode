class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int max = 0;
        for (int x : costs) {
            max = Math.max(max, x);
        }
        int[] freq = new int[max + 1];

        for (int c : costs) {
            freq[c]++;
        }

        int ans = 0;

        for (int cost = 1; cost <= max; cost++) {
            while (freq[cost] > 0 && coins >= cost) {
                coins -= cost;
                freq[cost]--;
                ans++;
            }
        }

        return ans;
    }
}