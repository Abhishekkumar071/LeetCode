class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int ele: nums){  
            int mod = ele%value;
            if(mod<0) mod += value;
            map.put(mod, map.getOrDefault(mod, 0)+1);
        }
        int i=0;
        while(i<=100000){
            if(!map.containsKey(i%value)) break;
            int f = map.get(i%value);
            if(f==1) map.remove(i%value);
            else map.put(i%value, f-1);
            i++;
        }
        return i;
    }
}