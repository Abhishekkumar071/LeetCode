class Solution {
    public List<Integer> maxScoreIndices(int[] nums) {
        int max = 0;
        int n=nums.length;
        int tot = 0;
        List<Integer> ans = new ArrayList<>();
        for(int ele: nums){
            if(ele==1) tot++;
        }

        int zero=0;
        int one=0;

        for(int i=0; i<n; i++){
            max = Math.max(max, zero+(tot-one));
            if(nums[i]==0) zero++;
            else one++;
            max = Math.max(max, zero+(tot-one));
        }
        if(max==one) ans.add(0);
        zero=0;
        one=0;
        for(int i=0; i<n; i++){
            if(nums[i]==0) zero++;
            else one++;
            if(max==(zero+(tot-one))){
                ans.add(i+1);
            }
        }
        return ans;
    }
}