class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int ans=0;
        for(int ele: costs){
            if(coins<ele) break;
            ans++;
            coins-=ele;
        }return ans;
    }
}