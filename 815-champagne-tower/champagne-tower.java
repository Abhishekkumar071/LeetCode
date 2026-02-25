class Solution {
    public double champagneTower(int n, int r, int c) {
       double[][] arr = new double[r+2][r+2];

        int i=0;
        arr[0][0] = (double)n;
        boolean overflow = true;
        while(overflow&&i<=r){
             overflow = false;
            for(int j=0; j<=i; j++){
               
                if(arr[i][j]>1){
                    double c1 = arr[i][j]-1;
                    arr[i][j]=1;
                    
                    overflow = true;
                    arr[i+1][j] += c1/2.0;
                    arr[i+1][j+1]  += c1/2.0;
                }
            }
            i++;
        }
        return arr[r][c];
    }
}