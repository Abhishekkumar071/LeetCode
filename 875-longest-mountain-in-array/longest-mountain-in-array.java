class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];

        for(int i=1; i<n; i++){
            if(arr[i]>arr[i-1]){
                left[i] = left[i-1]+1;
            }
        }
        for(int i=n-2; i>=0; i--){
            if(arr[i]>arr[i+1]){
                right[i] = right[i+1]+1;
            }
        }
        int ans = 0;
        for(int i=0; i<n; i++){
            if(left[i]!=0 && right[i]!=0)ans = Math.max(ans, 1+left[i]+right[i]);
        }
        // System.out.println(Arrays.toString(left));
        // System.out.println(Arrays.toString(right));
        return ans;
    }
}