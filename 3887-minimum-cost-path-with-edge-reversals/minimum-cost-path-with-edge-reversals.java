class Solution {
    public int minCost(int n, int[][] ed) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e: ed){
            int u = e[0];
            int v = e[1];
            int w = e[2];
            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, 2*w});
        }
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0]=0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.add(new int[]{0, 0});
        
        while(!pq.isEmpty()){
            int[] top = pq.poll();
            int d = top[0];
            int u = top[1];
            if(d>dist[u]) continue;
            for(int[] node: adj.get(u)){
                int v = node[0];
                int w = node[1];
                if(dist[u]+w<dist[v]){
                    dist[v]=dist[u]+w;
                    pq.offer(new int[]{dist[v], v});
                }
            }
        }
        return dist[n-1]==2147483647?-1:dist[n-1];
    }
}