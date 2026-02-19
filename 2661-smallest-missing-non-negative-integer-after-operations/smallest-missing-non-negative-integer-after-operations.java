class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int n = nums.length;
        int[] freq =  new int[value];

        for(int ele: nums){  
            int mod = ele%value;
            if(mod<0) mod += value;
            freq[mod]++;
        }
        int i=0;
        while(true){
            if(freq[i%value]==0) break;
            freq[i%value]--;
            i++;
        }
        return i;
    }
}