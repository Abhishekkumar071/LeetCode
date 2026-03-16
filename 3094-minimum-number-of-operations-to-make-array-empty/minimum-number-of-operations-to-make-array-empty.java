class Solution {
    public int minOperations(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int ele: nums){
            map.put(ele, map.getOrDefault(ele, 0)+1);
        }
        int ans = 0;
        for(int val: map.values()){
            if(val==1) return -1;
            if(val%3==0) ans += val/3;
            else{
                ans += val/3;
                val = (val+1/3);
                if(val>0)ans +=1;
            }
        }
        return ans;
    }
}