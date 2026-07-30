class Solution {
    int[] color;
    boolean bfs(int n, List<List<Integer>> adj){
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        color[n]=1;
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int node: adj.get(curr)){
                if(color[node]==-1) {
                    q.offer(node);
                    color[node] = color[curr]==1?0:1;
                }
                else if(color[node]==color[curr])return false;
            }
        }
        return true;
    }
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] d: dislikes){
            int u = d[0];
            int v = d[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        color = new int[n+1];
        Arrays.fill(color, -1);
        for(int i = 1; i<=n; i++) {
            if(color[i] == -1) {
                if(!bfs(i, adj)) {
                    return false;
                }
            }
        }
        
        return true;
    }
}