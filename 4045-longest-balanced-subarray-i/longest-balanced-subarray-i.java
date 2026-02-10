class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int ans=0;
        // int[][] arr = new int[n][2];
        // if(nums[0]%2==0) arr[0][0]=1;
        // else arr[0][1]=1;
        // for(int i=1; i<n; i++){
        //     if(nums[i]%2==0){
        //         arr[i][0]=arr[i-1][0]+1;
        //     }
        //     else arr[i][1]=arr[i-1][1]+1;
        // }
        for(int i=0; i<n; i++){
            Set<Integer> even = new HashSet<>();
            Set<Integer> odd = new HashSet<>();
            for(int j=i; j<n; j++){
                if(nums[j]%2==0) even.add(nums[j]);
                else odd.add(nums[j]);
                if(odd.size()==even.size()){
                    ans=Math.max(ans, j-i+1);
                }
            }
        }
        return ans;
    }
}