import java.util.*;

class Solution {
    Map<String, Integer> memo = new HashMap<>();

    public int lastStoneWeightII(int[] stones) {
        return solve(stones, 0, 0);
    }

    int solve(int[] stones, int i, int sum) {
        if (i == stones.length) {
            return Math.abs(sum);
        }

        String key = i + "," + sum;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int add = solve(stones, i + 1, sum + stones[i]);
        int subtract = solve(stones, i + 1, sum - stones[i]);

        int res = Math.min(add, subtract);
        memo.put(key, res);

        return res;
    }
}