class Solution {
    public int maxStarSum(int[] vals, int[][] e, int k) {
        int n = vals.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        // Store neighbor VALUES instead of indices
        for (int[] edge : e) {
            adj.get(edge[0]).add(vals[edge[1]]);
            adj.get(edge[1]).add(vals[edge[0]]);
        }

        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            List<Integer> neighbors = adj.get(i);
            // Sort neighbor values descending
            Collections.sort(neighbors, Collections.reverseOrder());

            int currentStarSum = vals[i];
            maxSum = Math.max(maxSum, currentStarSum); // Case: 0 neighbors

            // Add up to k positive neighbors
            for (int j = 0; j < Math.min(neighbors.size(), k); j++) {
                if (neighbors.get(j) > 0) {
                    currentStarSum += neighbors.get(j);
                    maxSum = Math.max(maxSum, currentStarSum);
                } else {
                    break; // Neighbors are sorted; no more positive values
                }
            }
        }
        return maxSum;
    }

}