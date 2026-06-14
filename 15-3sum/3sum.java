class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashSet<Integer> set = new HashSet<>();
        set.add(nums[0]);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> s = new HashSet<>();
        for(int j=1; j<n; j++){
            for(int k=j+1; k<n; k++){
                int r = nums[j]+nums[k];
                if(set.contains(-1*r)){
                    ArrayList<Integer> l = new ArrayList<>();
                    l.add(-1*r);
                    l.add(nums[j]);
                    l.add(nums[k]);
                    s.add(l);
                }
            }
            set.add(nums[j]);
        }
        for(List<Integer> l: s){
            ans.add(l);
        }
        return ans;
    }
}