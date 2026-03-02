class Solution {
    public int numEnclaves(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<m; i++){
            if(mat[i][0]==1){
                mat[i][0]=0;
                q.add(new int[]{i, 0});
            }
            if(mat[i][n-1]==1){
                mat[i][n-1]=0;
                q.add(new int[]{i, n-1});
            }
        }
        for(int i=0; i<n; i++){
            if(mat[0][i]==1){
                mat[0][i]=0;
                q.add(new int[]{0, i});
            }
            if(mat[m-1][i]==1){
                mat[m-1][i]=0;
                q.add(new int[]{m-1, i});
            }
        }
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while(!q.isEmpty()){
            int[] cell = q.poll();

            for(int[] d: dir){
                int nx = cell[0]+d[0];
                int ny = cell[1]+d[1];

                if(nx>=0 && ny>=0 && nx<m && ny<n && mat[nx][ny]==1){
                    q.add(new int[]{nx, ny});
                    mat[nx][ny]=0;
                }
            }
        }
        int ans = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++) if(mat[i][j]==1) ans++;
        }
        return ans;
    }
}