class Solution {
    int[] org;
    Random rand;
    public Solution(int[] nums) {
        org = nums.clone();
        rand = new Random();
    }
    
    public int[] reset() {
        return org.clone();
    }
    
    public int[] shuffle() {
        int[] arr = org.clone();
        for(int i=0; i<arr.length; i++){
            int j = i + rand.nextInt(arr.length-i);

            int temp  = arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
        }
        return arr;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */