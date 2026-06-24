class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        int des = graph.length-1;
        List<Integer> curr = new ArrayList<>();
        curr.add(0);
        dfs(0, des, curr, ans, graph);
        return ans;
    }
    void dfs(int src, int des, List<Integer> curr, List<List<Integer>> ans, int[][] g){
        if(src==des){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int c: g[src]){
            curr.add(c);
            dfs(c, des, curr, ans, g);
            curr.remove(curr.size()-1);
        }
    }
}