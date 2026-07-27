class Solution {
    static class State{
        long cost;
        int parity;
        int r;
        int c;
        State(long cost, int p, int i, int j){
            this.cost = cost;
            this.parity = p;
            this.r = i;
            this.c = j;
        }
    }
    public long minCost(int m, int n, int[][] penalty) {
        long[][][] dist = new long[m][n][2];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++) Arrays.fill(dist[i][j], Long.MAX_VALUE);
        }
        PriorityQueue<State> pq = new PriorityQueue<>((a, b)->Long.compare(a.cost, b.cost));
        pq.offer(new State(1, 0, 0, 0));
        dist[0][0][0] = 1;
        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while(!pq.isEmpty()){
            State curr = pq.poll();
            long cost = curr.cost;
            int parity = curr.parity;
            int i=curr.r;
            int j=curr.c;

            int newParity = parity^1;
            long waitCost = cost + penalty[i][j];
            if(waitCost<dist[i][j][newParity]){
                dist[i][j][newParity] = waitCost;
                pq.offer(new State(waitCost, newParity, i, j));
            }
            for(int[] d: dir){
                int ni = i+d[0];
                int nj = j+d[1];
                if(ni<0 || nj<0 || ni>=m || nj>=n) continue;
                long newCost = cost+1L*(ni+1)*(nj+1);

                if(newParity==1 && d[0]+d[1]==-1){
                    newCost += penalty[i][j];
                }else if(newParity==0 && d[0]+d[1]==1){
                    newCost += penalty[i][j];
                }
                if(newCost<dist[ni][nj][newParity]){
                    dist[ni][nj][newParity] = newCost;
                    pq.offer(new State(newCost, newParity, ni, nj));
                }
            }
        }
        return  Math.min(dist[m - 1][n - 1][0], dist[m - 1][n - 1][1]);
    }
}