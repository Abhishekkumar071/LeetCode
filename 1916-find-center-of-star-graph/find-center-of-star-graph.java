class Solution {
    public int findCenter(int[][] e) {
        List<Set<Integer>> adj = new ArrayList<>();
        int n = e.length;
        for(int i=0; i<=n; i++){
            adj.add(new HashSet<>());
        }
        for(int i=0; i<n; i++){
            int ui = e[i][0];
            int vi = e[i][1];
            adj.get(ui-1).add(vi-1);
            adj.get(vi-1).add(ui-1);
        }
        for(int i=0; i<=n; i++){
            Set<Integer> set = adj.get(i);
            if(set.size()==adj.size()-1) return i+1;
        }
        return 9;
    }
}