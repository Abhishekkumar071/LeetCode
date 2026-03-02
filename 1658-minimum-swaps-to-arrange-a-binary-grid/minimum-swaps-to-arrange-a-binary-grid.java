class Solution {
    public int minSwaps(int[][] mat) {
        int n = mat.length;
        int[] zero = new int[n];

        for(int i=0; i<n; i++){
            int count = 0;
            for(int j=n-1; j>=0; j--){
                if(mat[i][j]==0) count++;
                else break;
            }
            zero[i] = count;
        }
        // System.out.println(Arrays.toString(zero));
        int ans=0;
        for(int i=0; i<n; i++){
            int need = n-i-1;
            int j=i;
            while(j<n && zero[j]<need) j++;
            if(j==n) return -1;

            //jth row ko ith pr lao
            while(j>i){
                int temp = zero[j];
                zero[j]=zero[j-1];
                zero[j-1]=temp;
                j--;
                ans++;
            }
        }
        return ans;
    }
}