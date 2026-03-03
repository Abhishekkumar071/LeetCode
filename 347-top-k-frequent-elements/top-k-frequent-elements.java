class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] bucket = new ArrayList[nums.length+1];
        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            int key = e.getKey();
            int freq = e.getValue();
            if(bucket[freq]==null){
                bucket[freq]=new ArrayList<>();
            }
            bucket[freq].add(key);
        }

        int[] ans = new int[k];
        int idx=0;
        for(int i=bucket.length-1; i>=0 && idx<k; i--){
            if(bucket[i]!=null){
                for(int num: bucket[i]){
                    ans[idx++] = num;
                    if(idx==k) break;
                }
            }
        }
        return ans;
    }
}