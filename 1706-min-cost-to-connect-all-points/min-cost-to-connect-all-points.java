class Solution {
    public int minCostConnectPoints(int[][] p) {
        int ans= 0;
        int n = p.length;
        boolean[] vis = new boolean[n];
        int[] min = new int[n];
        Arrays.fill(min, Integer.MAX_VALUE);
        min[0]=0;
        for(int i=0; i<n; i++){
            int u = -1;
            for(int j=0; j<n; j++){
                if(!vis[j]&& (u==-1 || min[j]<min[u])){
                    u=j;
                }
            }
            ans += min[u];
            vis[u] = true;

            for(int v=0; v<n; v++){
                if(!vis[v]){
                    int dist =
                        Math.abs(p[u][0] - p[v][0]) +
                        Math.abs(p[u][1] - p[v][1]);
                    min[v] = Math.min(min[v], dist);
                }
            }
        }
        return ans;
    }
}