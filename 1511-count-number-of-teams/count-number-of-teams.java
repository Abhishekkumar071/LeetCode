class Solution {
    public int numTeams(int[] arr) {
        int n = arr.length;
        int ans=0;
        for(int j=1; j<n; j++){
            int ls = 0;
            int lg = 0;
            int rs = 0;
            int rg=0;
            for(int i=0; i<j; i++){
                if(arr[i]<arr[j]) ls++;
                else if(arr[i]>arr[j]) lg++;
            }
            for(int i=j+1; i<n; i++){
                if(arr[i]<arr[j]) rs++;
                else if(arr[i]>arr[j]) rg++;
            }
            ans+= (ls*rg);
            ans+= (lg*rs);
        }
        return ans;
    }
}