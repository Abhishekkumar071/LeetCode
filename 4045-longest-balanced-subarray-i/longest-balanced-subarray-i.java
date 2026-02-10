class Solution {
    short[] freq = new short[100001];
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int ans=0;
        
        for(int i=0; i<n; i++){
            int[] count = new int[2];
            for(int j=i; j<n; j++){
                if(++freq[nums[j]]==1){
                    count[nums[j]&1]++;
                }
                if(count[0]==count[1]){
                    ans=Math.max(ans, j-i+1);
                }
            }
            for(int j=i; j<n; j++) freq[nums[j]]=0;
        }
        return ans;
    }
}