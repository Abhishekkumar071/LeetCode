class Solution {
    List<List<Integer>> ans;
    HashSet<List<Integer>> set;
    private void backTrack(int st, int[] nums, List<Integer> path){
        if(st>=nums.length){
            if(path.size()>=2 && !set.contains(path)){
                ans.add(new ArrayList<>(path));
                set.add(ans.get(ans.size()-1));
            }
            return;
        }   
        boolean f = false;
        if(path.size()==0|| path.get(path.size()-1)<=nums[st]){
            path.add(nums[st]);
            f = true;
        }
        backTrack(st+1, nums, path);
        if(f && path.size()!=0) path.remove(path.size()-1);
        if(f) backTrack(st+1, nums, path);
        
    }
    public List<List<Integer>> findSubsequences(int[] nums) {
        int n = nums.length;
        ans = new ArrayList<>();
        set = new HashSet<>();
        backTrack(0, nums, new ArrayList<>());
        // Collections.sort(ans,(a,b)-> a.size()-b.size() );
        return ans;
    }
}