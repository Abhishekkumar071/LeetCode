class Solution {
    public int minMoves(int target, int max) {
        int ans = 0;

        while (target > 1 && max > 0) {

            if (target % 2 == 0) {
                target /= 2;
                max--;
            } else {
                target -= 1;
            }

            ans++;
        }
        if (target > 1) {
            ans += target - 1;
        }

        return ans;
    }
}