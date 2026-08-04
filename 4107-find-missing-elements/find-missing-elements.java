class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        int min=nums[0];
        for(int ele: nums){
            while(min+1<ele){
                ans.add(++min);
            }
            min=ele;
        }
        return ans;
    }
}