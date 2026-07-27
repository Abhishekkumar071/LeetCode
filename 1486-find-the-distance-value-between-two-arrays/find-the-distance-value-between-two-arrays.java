class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int ans=0;
        for(int ele: arr1){
            boolean yes = true;
            for(int e: arr2){
                if(Math.abs(e-ele)<=d){
                    yes=false;
                    break;
                }
            }
            if(yes)ans++;
        }
        return ans;
    }
}