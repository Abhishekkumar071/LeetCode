class Solution {

        private int dfs(int i, int prev, int[][] grid, Integer[][] dp){
                if(i == grid.length) return 0;

                        if(dp[i][prev] != null) return dp[i][prev];

                                int min = Integer.MAX_VALUE;
                                        int n = grid.length;

                                                for(int c = 0; c < n; c++){
                                                            if(c != prev){
                                                                            int curr = grid[i][c] + dfs(i + 1, c, grid, dp);
                                                                                            min = Math.min(min, curr);
                                                                                                        }
                                                                                                                }

                                                                                                                        return dp[i][prev] = min;
                                                                                                                            }

                                                                                                                                public int minFallingPathSum(int[][] grid) {

                                                                                                                                        int n = grid.length;
                                                                                                                                                int ans = Integer.MAX_VALUE;

                                                                                                                                                        Integer[][] dp = new Integer[n][n];

                                                                                                                                                                for(int c = 0; c < n; c++){
                                                                                                                                                                            ans = Math.min(ans, grid[0][c] + dfs(1, c, grid, dp));
                                                                                                                                                                                    }

                                                                                                                                                                                            return ans;
                                                                                                                                                                                                }
                                                                                                                                                                                                }
